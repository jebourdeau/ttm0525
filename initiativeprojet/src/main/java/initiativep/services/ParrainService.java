package initiativep.services;

import java.util.NoSuchElementException;

import initiativep.repository.jpa.ParrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import initiativep.dto.ParrainDto;
import initiativep.model.Parrain;

@Service
public class ParrainService {

    @Autowired
    private ParrainRepository parrainRepository;

    public Parrain createParrain(ParrainDto parrainDTO) {
        Parrain parrain = (Parrain) Parrain.builder()
                .username(parrainDTO.getUsername())
                .email(parrainDTO.getEmail())
                .password(parrainDTO.getPassword())
                .build();
        return parrainRepository.save(parrain);
    }

    public void deleteParrain(String id){
        parrainRepository.deleteById(id);
    }
    public Parrain updateParrain(String id, ParrainDto parrainDTO){
        Parrain parrain= parrainRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Parrain not found"));
        parrain.setUsername(parrainDTO.getUsername());
        parrain.setEmail(parrainDTO.getEmail());
        parrain.setPassword(parrainDTO.getPassword());
        parrain.setEntreprise(parrainDTO.getEntreprise());
        return parrainRepository.save(parrain);
    }
}

