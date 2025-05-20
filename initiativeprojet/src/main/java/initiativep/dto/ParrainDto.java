package initiativep.dto;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParrainDto {
        private String entreprise;
        private String username;
        private String email;
        private String password;
}
