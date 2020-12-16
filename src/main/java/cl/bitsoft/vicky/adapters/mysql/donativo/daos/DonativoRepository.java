package cl.bitsoft.vicky.adapters.mysql.donativo.daos;

import cl.bitsoft.vicky.adapters.mysql.donativo.entities.DonativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonativoRepository extends JpaRepository<DonativoEntity, Long> {

}
