package initiativep.services;

import initiativep.dto.AuthResponse;
import initiativep.dto.RegisterDto;
import initiativep.repository.UserRepository;
import initiativep.security.JwtService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Setter
@Getter
public class AuthService{
    private UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthResponse authResponse;




}
