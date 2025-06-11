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
@DiscriminatorValue("porteur")
public class Porteur extends User{

    @ManyToOne
    private Parrain parrain;

}