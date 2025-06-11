package initiativep.services;

import initiativep.dto.AuthResponse;
import initiativep.repository.jpa.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Setter
@Getter
public class AuthService{
    private UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;
    private AuthResponse authResponse;


}
