package cl.bitsoft.vicky.domain.services.donativo;

import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import cl.bitsoft.vicky.domain.persistence_ports.donativo.DonativoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Donativo> findDonativosByIdDonante(Long id) {
        return this.donativoPersistence.findDonativosByIdDonante(id);
    }
}
