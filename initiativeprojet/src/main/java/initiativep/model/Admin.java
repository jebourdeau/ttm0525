package initiativep.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "admin")
@DiscriminatorValue("admin")
public class Admin extends User {

}
