package cl.bitsoft.vicky.domain.persistence_ports.donativo;

import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonativoPersistence {
    public List<Donativo> readAll();
    public Donativo create(Donativo donativo);
//    public List<Donativo> findDonativosByDonanteOrBeneficiario(Long IdDonante, Long IdBeneficiario);
     List<Donativo> findDonativosByDonante(Long id);
     List<Donativo> findDonativosByBeneficiario(Long id);
     Donativo findById(Long id);
}
