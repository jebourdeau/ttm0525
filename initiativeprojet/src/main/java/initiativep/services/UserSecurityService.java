package initiativep.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import initiativep.model.User;

@Service
public class UserSecurityService {
    private final UserService userService;
    @Autowired
    public UserSecurityService(UserService userService){
        this.userService = userService;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= User.builder().build();

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(new ArrayList<>())
                .build();
    }
}
