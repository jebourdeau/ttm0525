package initiativep.controller;

import initiativep.dto.ProjetDto;
import initiativep.model.Projet;
import initiativep.services.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projet")
public class ProjetController {
    @Autowired
    private ProjetService projetService;

    @GetMapping
    public ResponseEntity<List<ProjetDto>>getAllProjets(){
        List<ProjetDto> projets = projetService.getAllProjets();
        if (projets.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(projets);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjetDto> getProjetById(@PathVariable Long id){
        ProjetDto projet = projetService.getProjetById(id);
        if(projet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projet);
    }
    @PostMapping
    public ResponseEntity<ProjetDto> createProjet(@RequestBody ProjetDto projetDto){
        ProjetDto projetCreer = projetService.save(projetDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(projetCreer);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Projet> deleteProjet(@PathVariable Long id){
        ProjetDto projet = projetService.getProjetById(id);
        if (projet == null){
        return ResponseEntity.notFound().build();
        }
        projetService.deleteProjet(id);
        return ResponseEntity.noContent().build();
    }


}
