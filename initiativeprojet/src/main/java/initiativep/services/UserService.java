package initiativep.services;

import initiativep.dto.UserDto;
import initiativep.model.User;
import initiativep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService{

    @Autowired
    UserRepository userRepository;

    public List<UserDto> getAllUsers(){
        return 
        userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    public Optional<User>findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public UserDto getUserById(Long id){
        return userRepository.findById(id).map(this::convertToDTO).orElse(null);
    }
    public UserDto createUSer(UserDto userDto){
        User user= convertToEntity(userDto);
        user= userRepository.save(user);
        return convertToDTO(user);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    private UserDto convertToDTO(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole());
        userDto.setEmail(user.getEmail());
        userDto.setProjet(user.getProjet());
        return userDto;
    }
    private User convertToEntity(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        user.setProjet(userDto.getProjet());
        return user;
    }
}