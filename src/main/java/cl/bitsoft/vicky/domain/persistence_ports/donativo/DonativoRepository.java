package cl.bitsoft.vicky.domain.persistence_ports.donativo;

import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonativoRepository extends JpaRepository<Donativo, Long> {

}
