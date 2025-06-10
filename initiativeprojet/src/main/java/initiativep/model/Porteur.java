package initiativep.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "porteur")
//@DiscriminatorValue("porteur")
public class Porteur extends User{
    private String title;
    private String description;

    @OneToOne
//    @JoinColumn(name = "porteur_id", nullable = false)
    private Porteur porteur;

    @ManyToOne
//    @JoinColumn(name = "parrain_id")
    private Parrain parrain;

    private Set<Role> roles = new HashSet<>();

}