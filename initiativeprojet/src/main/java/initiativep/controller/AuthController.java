package initiativep.controller;

import initiativep.dto.AuthRequest;
import initiativep.dto.AuthResponse;
import initiativep.dto.RegisterDto;
import initiativep.security.JwtService;
import initiativep.services.AuthService;
import org.springframework.http.ResponseEntity;
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

    public AuthController(AuthService authService, JwtService jwtService, UserService userService){
        this.authService = authService;
        this.jwtService = jwtService;
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto request){
        authService.register(request);
        return ResponseEntity.ok("User register");
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}