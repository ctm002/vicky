package cl.bitsoft.vicky.adapters.mysql.donativo.persistence;

import cl.bitsoft.vicky.domain.models.usuario.Usuario;
import cl.bitsoft.vicky.domain.persistence_ports.usuario.UsuarioPersistence;
import org.springframework.stereotype.Repository;

@Repository("usuarioPersistence")
public class UsuarioPersistenceMysql implements UsuarioPersistence {
    @Override
    public Usuario findById(Long id) {
        return null;
    }
}
