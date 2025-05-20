package initiativep.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import initiativep.model.Parrain;



@Repository
public interface ParrainRepository extends JpaRepository<Parrain, Long> {
    Optional<Parrain> findByName(String name);
    Optional<Parrain> findByEmail(String email);
    Optional<Parrain>findbyIdParrain(Long id);
}
