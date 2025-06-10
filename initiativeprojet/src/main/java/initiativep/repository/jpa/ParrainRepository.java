package initiativep.repository.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import initiativep.model.Parrain;



@Repository
public interface ParrainRepository extends JpaRepository<Parrain, String> {
}
