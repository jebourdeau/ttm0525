//package Initiative.initiativeprojet;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import static org.mockito.ArgumentMatchers.any;
//import org.mockito.Mock;
//import static org.mockito.Mockito.when;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import initiativep.model.Projet;
//import initiativep.model.User;
//import initiativep.repository.jpa.ProjetRepository;
//import initiativep.repository.jpa.UserRepository;
//import initiativep.services.ProjetService;
//
//@ExtendWith(MockitoExtension.class)
//class InitiativeprojetApplicationTests {
//	@Mock
//	private ProjetRepository projetRepository;
//
//	@Mock
//	private UserRepository userRepository;
//
//	@Autowired
//	private ProjetService projetService;
//
//	@Test
//	public void creationProjet() {
//		// Arrange
//		String idUser = "1";
//		User user = User.builder().id(1L).username("shiipou").build();
//		when(userRepository.findById(idUser)).thenReturn(Optional.of(user));
//		String nomProjet = "Nouveau Projet";
//		Projet projetFromDB = Projet.builder().id(1L).owner(user).name(nomProjet).build();
//		when(projetRepository.save(any(Projet.class))).thenReturn(projetFromDB);
//
//		// Act
//		Projet projet = projetService.creationProjet(idUser, nomProjet);
//
//		// Assert
//		Assertions.assertEquals(projet.getOwner().getUsername(), user.getUsername());
//	}
//
//
//}
