package cl.bitsoft.vicky.adapters.mysql.donativo.persistence;

import cl.bitsoft.vicky.adapters.mysql.donativo.daos.DonativoRepository;
import cl.bitsoft.vicky.adapters.mysql.donativo.daos.UsuarioRepository;
import cl.bitsoft.vicky.adapters.mysql.donativo.entities.DonativoEntity;
import cl.bitsoft.vicky.adapters.mysql.usuario.UsuarioEntity;
import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import cl.bitsoft.vicky.domain.models.donativo.Postulante;
import cl.bitsoft.vicky.domain.persistence_ports.donativo.DonativoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("donativoPersistence")
public class DonativoPersistenceMysql implements DonativoPersistence {

    private DonativoRepository donativoRepository;
    private UsuarioRepository  usuarioRepository;

    @PersistenceContext(unitName = "recicladonaEntityManager")
    EntityManager entityManager;

    @Autowired
    public DonativoPersistenceMysql(DonativoRepository donativoRepository, UsuarioRepository  usuarioRepository) {
        this.donativoRepository = donativoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Donativo> readAll() {
        return this.donativoRepository.findAll().stream()
                .map(donativoEntity -> donativoEntity.toDonativo())
                .collect(Collectors.toList());
    }

    @Override
    public Donativo create(Donativo donativo) {
        return this.donativoRepository.save(new DonativoEntity(donativo)).toDonativo();
    }

//    public List<Donativo> findDonativosByDonanteOrBeneficiario(Long IdDonante, Long IdBeneficiario) {
//        CriteriaBuilder               criteriaBuilder          = entityManager.getCriteriaBuilder();
//        CriteriaQuery<DonativoEntity> criteriaQuery            = criteriaBuilder.createQuery(DonativoEntity.class);
//        Root<DonativoEntity>          itemRoot                 = criteriaQuery.from(DonativoEntity.class);
//        Predicate                     predicateForDonador      = criteriaBuilder.equal(itemRoot.get("donador"), IdDonante);
//        Predicate                     predicateForBeneficiario = criteriaBuilder.equal(itemRoot.get("beneficiario"), IdBeneficiario);
//
//        Predicate finalPredicate = criteriaBuilder.or(predicateForDonador, predicateForBeneficiario);
//        criteriaQuery.where(finalPredicate);
//        List<Donativo> items = entityManager.createQuery(criteriaQuery).getResultList().stream()
//                .map(donativoEntity -> donativoEntity.toDonativo()).collect(Collectors.toList());
//        return items;
//    }

    @Override
    public List<Donativo> findDonativosByDonante(Long id) {
        Optional<UsuarioEntity> usuarioEntity = this.usuarioRepository.findById(id);
        return this.donativoRepository.findByDonador(usuarioEntity.get()).stream()
                .map(donativoEntity -> donativoEntity.toDonativo()).collect(Collectors.toList());
    }

    @Override
    public List<Donativo> findDonativosByBeneficiario(Long id) {
        Optional<UsuarioEntity> usuarioEntity = this.usuarioRepository.findById(id);
        return this.donativoRepository.findByBeneficiario(usuarioEntity.get()).stream()
                .map(donativoEntity -> donativoEntity.toDonativo()).collect(Collectors.toList());
    }

    @Override
    public Donativo findById(Long id) {
        return this.donativoRepository.findById(id).get().toDonativo();
    }

}
