package initiativep.repository.jpa;

import initiativep.model.Porteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorteurRepository extends JpaRepository<Porteur, Long> {
}
