package cl.bitsoft.vicky.domain.services.donativo;

import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import cl.bitsoft.vicky.domain.models.donativo.Postulante;
import cl.bitsoft.vicky.domain.models.usuario.Usuario;
import cl.bitsoft.vicky.domain.persistence_ports.donativo.DonativoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DonativoService {

    private DonativoPersistence donativoPersistence;

    @Autowired
    public DonativoService(DonativoPersistence donativoPersistence) {
        this.donativoPersistence = donativoPersistence;
    }

    public List<Donativo> readAll() {
        return this.donativoPersistence.readAll();
    }

    public Donativo create(Donativo donativo) {
        return this.donativoPersistence.create(donativo);
    }

    public List<Donativo> findDonativosByDonanteOrBeneficiario(Long id) {
        return this.donativoPersistence.findDonativosByDonante(id);
    }

    public List<Donativo> findDonativosByDonante(Long id) {
        return this.donativoPersistence.findDonativosByDonante(id);
    }

    public List<Donativo> findDonativosByBeneficiario(Long id) {
        return this.donativoPersistence.findDonativosByBeneficiario(id);
    }

    public Donativo create(String id, String idUsuario) {
        Usuario usuario = new Usuario();
        usuario.setId(Long.parseLong(idUsuario));
        Postulante postulante = new Postulante();
        postulante.setUsuario(usuario);
        postulante.setFecha(LocalDateTime.now());
        postulante.setEstado(1);
        Donativo donativo = this.donativoPersistence.findById(Long.parseLong(id));
        donativo.postulantes.add(postulante);
        this.donativoPersistence.create(donativo);
        return null;
    }
}
