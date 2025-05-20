package initiativep.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "parrains")
public class Parrain extends User{

    private String entreprise;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "parrain_roles",
            joinColumns = @JoinColumn(name ="parrain_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    @OneToMany(mappedBy = "parrain")
    private List<Projet> projetsEncadres;

    @OneToMany(mappedBy = "parrain")
    private List<RendezVous> rendezVous;


}
