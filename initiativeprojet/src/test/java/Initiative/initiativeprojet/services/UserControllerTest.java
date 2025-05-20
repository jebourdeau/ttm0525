package Initiative.initiativeprojet.services;

import initiativep.model.User;
import initiativep.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RestController
@RequestMapping("/users")
public class UserControllerTest {
    @Autowired
    @MockBean
    private UserService userService;

    @GetMapping("{/id}")
    public ResponseEntity<User> getUSerById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void testGetUserById() throws Exception{
            User user = new User();
            user.setId(1L);
            user.setUsername("John Doe");

            Mockito.when(userService.findById(1L)).thenReturn(user);
            mockMvc.perform(get("/users/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.username").value("John Doe"));
        }

    }


