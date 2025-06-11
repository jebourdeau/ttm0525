package initiativep.services;

import initiativep.dto.UserDto;
import initiativep.model.Admin;
import initiativep.model.Parrain;
import initiativep.model.Porteur;
import initiativep.model.User;
import initiativep.repository.jpa.AdminRepository;
import initiativep.repository.jpa.ParrainRepository;
import initiativep.repository.jpa.PorteurRepository;
import initiativep.repository.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;
    private final PorteurRepository porteurRepository;
    private final ParrainRepository parrainRepository;

    public List<UserDto> getAllUsers(){
        return 
        userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    public Optional<User>findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public Optional<User>findByUsernameAndPassword(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }
    public Optional<User> findById(String id){
        return userRepository.findById(id);
    }

    public UserDto getUserById(String id){
        return userRepository.findById(id).map(this::convertToDTO).orElse(null);
    }
    public UserDto createUSer(UserDto userDto){
        User user = convertToEntity(userDto);
        if(user instanceof Admin) {
            user = adminRepository.saveAndFlush((Admin)user);
        } else if(user instanceof Parrain) {
            user = parrainRepository.saveAndFlush((Parrain)user);
        } else if(user instanceof Porteur) {
            user = porteurRepository.saveAndFlush((Porteur)user);
        } else {
            throw new RuntimeException("Invalid user type");
        }
        user = userRepository.saveAndFlush(user);
        return convertToDTO(user);
    }
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
    private UserDto convertToDTO(User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setAge(user.getAge());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        if(user instanceof Admin) {
            userDto.setRole("admin");
        } else if (user instanceof Parrain) {
            userDto.setRole("parrain");
        } else if(user instanceof Porteur) {
            userDto.setRole("porteur");
        }
        return userDto;
    }
    private User convertToEntity(UserDto userDto){
        User user;
        if(userDto.getRole().equals("admin")) {
            user = new Admin();
        } else if (userDto.getRole().equals("parrain")) {
            user = new Parrain();
        }else if(userDto.getRole().equals("porteur")){
            user = new Porteur();
        }else {
        throw new RuntimeException("Wrong Role");
        }
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return user;
    }
}