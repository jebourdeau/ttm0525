package initiativep.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;
        private String email;
        private String password;
        private String role;
        private String projet;
        private int age;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id")
        )
        private Set<Role> roles = new HashSet<>();

        @OneToMany(mappedBy = "user")
        private List<Projet> projets;

        @OneToMany(mappedBy = "user")
        private List<RendezVous> rendezVous;
}
