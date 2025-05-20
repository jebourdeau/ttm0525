package initiativep.dto;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private int age;
    private String email;
    private String role;
    private String projet;
    private String password;
}
