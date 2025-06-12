package initiativep.controller;

import initiativep.dto.*;
import initiativep.model.User;
import initiativep.repository.jpa.UserRepository;
import initiativep.security.JwtTokenProvider;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import initiativep.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtTokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        User user = userService.findByUsername(username).
                orElseThrow(
                        ()->new RuntimeException("Wrong Credentials"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
             throw new RuntimeException("Wrong Credentials");
        }
        System.out.println("user = " + user);
        String jwt = tokenProvider.generateToken(user);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt,"Bearer", user.getId(), user.getUsername()));
    }
    @PostMapping("/register")
    public ResponseEntity<JwtAuthenticationResponse> createUser(@RequestBody UserDto userDto){
        User createdUser = userService.createUSer(userDto);
        String jwt = tokenProvider.generateToken(createdUser);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt,"Bearer", createdUser.getId(), createdUser.getUsername()));
    }
    
    @PostMapping("/logout")
    @PermitAll
    public ResponseEntity<?> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok().build();
    }
}