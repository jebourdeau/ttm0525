package initiativep.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Porteur extends User{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "porteur_roles",
            joinColumns = @JoinColumn(name ="projet_id")
    )
    private Projet projet;
}
