package Initiative.initiativeprojet.services;

import initiativep.model.Projet;
import initiativep.model.User;
import initiativep.repository.ProjetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import initiativep.repository.ParrainRepository;
import initiativep.repository.UserRepository;
import initiativep.services.ProjetService;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InitiativeTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private ParrainRepository parrainRepository;
    @Mock
    private ProjetRepository projetRepository;
    @InjectMocks
    private ProjetService projetService;

    @Test
    public void creationProjet(){
        long idUser = 1;

        User user = User.builder()
                .id(1L)
                .username("test")
                .build();

        // Mock user
        when(userRepository.findById(idUser)).thenReturn(Optional.of(user));

        // Second paramètre
        String nomProjet = "Projet";

        // Mock Create projet
        Projet projetFromDB = Projet.builder()
                .id(1L)
                .owner(user)
                .name(nomProjet)
                .build();

        when(projetRepository.save(any(Projet.class))).thenReturn(projetFromDB);

        // troisieme paramètre
//        long idParrain = 4L;
//
//        // Mock parrain
//        Parrain parrain = Parrain.builder()
//                .id(4L)
//                .name("état")
//                .entreprise("en déficite")
//                .build();
//
//        when(parrainRepository.save(any(Parrain.class))).thenReturn(parrain);

        // Execution du code de l'app
        Projet projet = projetService.creationProjet(idUser, nomProjet);

        assertEquals(projet.getOwner().getUsername(), user.getUsername());
        assertEquals(projet.getName(), nomProjet);

    }

}
