package cl.bitsoft.vicky.adapters.mysql.donativo.daos;

import cl.bitsoft.vicky.adapters.mysql.donativo.entities.DonativoEntity;
import cl.bitsoft.vicky.adapters.mysql.usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonativoRepository extends JpaRepository<DonativoEntity, Long> {
    List<DonativoEntity> findByDonador(UsuarioEntity usuarioEntity);
    List<DonativoEntity> findByBeneficiario(UsuarioEntity usuarioEntity);
}
