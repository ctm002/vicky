package cl.bitsoft.vicky.domain.persistence_ports.donativo;

import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonativoPersistence {
    public List<Donativo> readAll();
    public Donativo create(Donativo donativo);
    public List<Donativo> findDonativosByIdDonante(Long id);
//    public List<Donativo> findByIdUsuarioBeneficiario(Long id);
}
