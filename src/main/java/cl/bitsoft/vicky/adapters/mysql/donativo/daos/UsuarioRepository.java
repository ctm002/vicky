package cl.bitsoft.vicky.adapters.mysql.donativo.daos;

import cl.bitsoft.vicky.adapters.mysql.usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {


}
