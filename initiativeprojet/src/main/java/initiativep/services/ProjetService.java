package initiativep.services;

import initiativep.dto.ProjetDto;
import initiativep.model.Porteur;
import initiativep.model.Projet;
import initiativep.model.User;
import initiativep.repository.ProjetRepository;
import initiativep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProjetService {
    @Autowired
    private ProjetRepository projetRepository;
    @Autowired
    private UserRepository userRepository;

    public List<ProjetDto> getAllProjets() {
        return
                projetRepository.findAll()
                        .stream()
                        .map(this::convertToDto)
                        .collect(Collectors.toList());
    }

    public ProjetDto getProjetById(Long id) {
        return projetRepository.findById(id).map(this::convertToDto).orElse(null);
    }

    public ProjetDto createProjet(ProjetDto projetDto) {
        Projet projet = convertToEntity(projetDto);
        projet = projetRepository.save(projet);
        return convertToDto(projet);
    }

    private ProjetDto convertToDto(Projet projet) {
        ProjetDto projetDto = new ProjetDto();
        projetDto.setId(projet.getId());
        projetDto.setTitle(projet.getTitle());
        projetDto.setDescription(projet.getDescription());
        projetDto.setUserId(projet.getUserId());
        return projetDto;
    }

    private Projet convertToEntity(ProjetDto projetDto) {
        Projet projet = new Projet();
        projet.setId(projetDto.getId());
        projet.setTitle(projetDto.getTitle());
        projet.setDescription(projetDto.getDescription());
        projet.setUserId(projetDto.getUserId());
        return projet;
    }

    public Projet creationProjet(long idUser, String nomProjet) {
        return this.creationProjet(idUser, nomProjet, new ArrayList<>());
    }

    public void deleteProjet(Long id) {
        projetRepository.deleteById(id);
    }

    public Projet creationProjet(long idUser, String nomProjet, List<User> membres)
            throws NoSuchElementException {
        User user = userRepository.findById(idUser).orElseThrow();

        Projet projet = Projet.builder()
                .porteur(new Porteur())
                .title("")
                .membres(membres)
                .build();

        return projetRepository.save(projet);
    }

    public Projet updateProjet(Long id, ProjetDto projetDto) {
        Projet projet = projetRepository.getReferenceById(id);
        projet.setId(projetDto.getId());
        projet.set(projet.getName());
        return projetRepository.save(projet);
    }
}
