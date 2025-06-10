package initiativep.services;

import initiativep.dto.ProjetDto;
import initiativep.model.Porteur;
import initiativep.model.Projet;
import initiativep.model.User;
import initiativep.repository.jpa.ProjetRepository;
import initiativep.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
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
        projetDto.setUserId(projet.getUser().getUsername());
        return projetDto;
    }

    private Projet convertToEntity(ProjetDto projetDto) {
        Optional<User> user = userRepository.findByUsername(projetDto.getUserId());
        Projet projet = new Projet();
        projet.setId(projetDto.getId());
        projet.setTitle(projetDto.getTitle());
        projet.setDescription(projetDto.getDescription());
        projet.setUser(user.orElseThrow());
        return projet;
    }

    public Projet creationProjet(String idUser, String nomProjet) {
        return this.creationProjet(idUser, nomProjet, new ArrayList<>());
    }

    public void deleteProjet(Long id) {
        projetRepository.deleteById(id);
    }

    public Projet creationProjet(String idUser, String nomProjet, List<User> membres)
            throws NoSuchElementException {
        User user = userRepository.findById(idUser).orElseThrow();

        Projet projet = Projet.builder()
                .porteur(new Porteur())
                .title("")
                .membres(membres)
                .build();


        return projetRepository.save(projet);
    }

    public ProjetDto save(ProjetDto projetDto) {
        if (projetRepository.existsById(projetDto.getId())) {
            throw new IllegalArgumentException("Ce porteur a déjà un projet.");
        }return new ProjetDto();
    }

}
