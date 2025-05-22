package initiativep.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "porteur")
public class Porteur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @OneToOne
    @JoinColumn(name = "porteur_id", nullable = false)
    private Porteur porteur;

    @ManyToOne
    @JoinColumn(name = "parrain_id")
    private Parrain parrain;
}