package initiativep.controller;

import initiativep.model.RendezVous;
import initiativep.repository.jpa.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendezvous")
public class RendezVousController {
    @Autowired
    private RendezVousRepository rendezVousRepository;

    @PostMapping
    public RendezVous createRendezVous(@RequestBody RendezVous rendezVous){
        return rendezVousRepository.save(rendezVous);
    }
    @GetMapping
    public List<RendezVous> getAllRendezVous(){
        return rendezVousRepository.findAll();
    }


}
