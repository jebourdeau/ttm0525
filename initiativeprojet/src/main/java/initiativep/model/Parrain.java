package initiativep.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "parrain")
@DiscriminatorValue("parrain")
public class Parrain extends User {
    private String entreprise;

    @OneToMany(mappedBy = "parrain")
    private List<Projet> projetsEncadres;

    @OneToMany(mappedBy = "parrain")
    private List<RendezVous> rendezVous;

}
