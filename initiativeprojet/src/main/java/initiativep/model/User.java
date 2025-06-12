package initiativep.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.core.serializer.Deserializer;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="role",
        discriminatorType = DiscriminatorType.STRING)
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String email;
        private String password;
        private int age;

        @OneToMany(mappedBy = "user")
        private List<Projet> projets;

        @OneToMany(mappedBy = "user")
        private List<RendezVous> rendezVous;
}
