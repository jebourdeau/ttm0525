//package Initiative.initiativeprojet.services;
//
//import initiativep.model.User;
//import initiativep.repository.jpa.UserRepository;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@SpringBootTest
//@ActiveProfiles("test")
//@Transactional
//public class UserRepositoryTest {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void testSaveAndFindUser() {
//        User user = new User();
//        user.setUsername("John Doe");
//
//        userRepository.save(user);
//
//        Optional<User> foundUser = userRepository.findUserById(user.getId());
//        assertTrue(foundUser.isPresent());
//        assertEquals("John Doe", foundUser.get().getUsername());
//    }
//}
