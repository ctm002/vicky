package cl.bitsoft.vicky.domain.services.donativo;

import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import cl.bitsoft.vicky.domain.persistence_ports.donativo.DonativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonativoService {

    private DonativoRepository donativoRepository;

    @Autowired
    public DonativoService(DonativoRepository donativoRepository) {
        this.donativoRepository = donativoRepository;
    }

    public List<Donativo> findAll() {
        return this.donativoRepository.findAll();
    }
}
