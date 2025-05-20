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

    public void register(RegisterDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email déjà utilisé");
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
    }

    public AuthResponse authenticate(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Mot de passe incorrect");
        }

        String jwt = jwtService.generateToken(user);
        return new AuthResponse(jwt);
    }
}


}
