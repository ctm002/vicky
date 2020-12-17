package cl.bitsoft.vicky.adapters.mysql.donativo.entities;

import cl.bitsoft.vicky.adapters.mysql.usuario.UsuarioEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "TBL_POSTULANTE")
public class PostulanteEntity {
    @Id
    @Column(name = "ID")
    private Long id;

//    @ManyToMany(mappedBy = "postulantes")
//    private List<DonativoEntity> donativos;

    @OneToOne
    @JoinColumn(name = "FK_ID_USUARIO")
    private UsuarioEntity usuarioEntity;

    public PostulanteEntity() {
    }
}
