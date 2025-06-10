package initiativep.services;

import initiativep.dto.UserDto;
import initiativep.model.User;
import initiativep.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<UserDto> getAllUsers(){
        return 
        userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    public Optional<User>findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public Optional<User> findById(String id){
        return userRepository.findById(id);
    }

    public UserDto getUserById(String id){
        return userRepository.findById(id).map(this::convertToDTO).orElse(null);
    }
    public UserDto createUSer(UserDto userDto){
        User user= convertToEntity(userDto);
        user= userRepository.save(user);
        return convertToDTO(user);
    }
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
    private UserDto convertToDTO(User user){
        UserDto userDto = new UserDto();
        userDto.setRole(user.getRole());
        userDto.setEmail(user.getEmail());
        userDto.setAge(user.getAge());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(passwordEncoder.encode(user.getPassword()));
//        userDto.setProjet(user.getProjet());
        return userDto;
    }
    private User convertToEntity(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setProjet(userDto.getProjet());
        return user;
    }
}