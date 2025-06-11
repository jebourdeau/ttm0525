package initiativep.controller;

import initiativep.dto.*;
import initiativep.model.User;
import initiativep.security.JwtService;
import initiativep.security.JwtTokenProvider;
import initiativep.services.AuthService;
import jakarta.annotation.security.PermitAll;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import initiativep.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtService jwtService;
    private final UserService userService;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider tokenProvider;

    public AuthController(AuthService authService, JwtService jwtService, UserService userService, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider){
        this.authService = authService;
        this.jwtService = jwtService;
        this.userService = userService;
        this.authenticationManager = authenticationManager;

    }
    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword()).orElseThrow(()->new RuntimeException("Wrong Credentials"));
        String jwt = tokenProvider.generateToken(user.getUsername());
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt,"Bearer", user.getId(), user.getUsername()));
    }
    @PostMapping("/register")
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUSer(userDto);
    }
    @PostMapping("/logout")
    @PermitAll
    public ResponseEntity<?> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok().build();
    }
}