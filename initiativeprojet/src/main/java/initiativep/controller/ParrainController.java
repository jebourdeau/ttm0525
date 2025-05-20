package initiativep.controller;

import initiativep.dto.ParrainDto;
import initiativep.model.Parrain;
import initiativep.services.ParrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parrain")
public class ParrainController {
    @Autowired
    private ParrainService parrainService;

    @PostMapping
    public ResponseEntity<Parrain> createParrain(@RequestBody ParrainDto parrainDto){
    Parrain parrain = parrainService.createParrain(parrainDto);
    return new ResponseEntity<>(parrain, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteParrain(@PathVariable Long id){
    parrainService.deleteParrain(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Parrain> updateParrain(@PathVariable Long id, @RequestBody ParrainDto parrainDto){
     Parrain updateParrain = parrainService.updateParrain(id, parrainDto);
     return new ResponseEntity<>(updateParrain, HttpStatus.OK);
    }

}
