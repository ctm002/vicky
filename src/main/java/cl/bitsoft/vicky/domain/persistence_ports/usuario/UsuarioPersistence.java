package cl.bitsoft.vicky.domain.persistence_ports.usuario;

import cl.bitsoft.vicky.domain.models.usuario.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioPersistence {
    Usuario findById(Long id);
}
