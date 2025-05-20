package initiativep.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Password {
    public static void main(String[] args){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String adminPassword= passwordEncoder.encode("admin");
        String userPassword = passwordEncoder.encode("user");
        String porteurPassword = passwordEncoder.encode("porteur");
        String parrainPassword = passwordEncoder.encode("parrain");
    }
}
