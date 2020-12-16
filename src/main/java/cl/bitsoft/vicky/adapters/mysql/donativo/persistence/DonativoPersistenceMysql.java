package cl.bitsoft.vicky.adapters.mysql.donativo.persistence;

import cl.bitsoft.vicky.adapters.mysql.donativo.daos.DonativoRepository;
import cl.bitsoft.vicky.adapters.mysql.donativo.entities.DonativoEntity;
import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import cl.bitsoft.vicky.domain.persistence_ports.donativo.DonativoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("donativoPersistence")
public class DonativoPersistenceMysql implements DonativoPersistence {

    private DonativoRepository donativoRepository;

    @Autowired
    public DonativoPersistenceMysql(DonativoRepository donativoRepository) {
        this.donativoRepository = donativoRepository;
    }

    @Override
    public List<Donativo> readAll() {
        return this.donativoRepository.findAll().stream().map(donativoEntity -> donativoEntity.toDonativo()).collect(Collectors.toList());
    }

    @Override
    public Donativo create(Donativo donativo) {
        return this.donativoRepository.save(new DonativoEntity(donativo)).toDonativo();
    }
}
