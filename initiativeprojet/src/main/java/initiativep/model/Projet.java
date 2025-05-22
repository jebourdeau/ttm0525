package initiativep.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projet")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<User> membres;
    @ManyToOne
    private Parrain parrain;

    @OneToOne
    private Porteur porteur;

}
