package cl.bitsoft.vicky.adapters.mysql.donativo.entities;


import cl.bitsoft.vicky.adapters.mysql.usuario.UsuarioEntity;
import cl.bitsoft.vicky.domain.models.donativo.Donativo;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;

@Entity(name = "TBL_DONATIVO")
public class DonativoEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "TITULO")
    public String titulo;

    @Column(name = "CANTIDAD")
    public Integer cantidad;

    @OneToOne
    @JoinColumn(name = "FK_ID_USUARIO_CREADOR")
    public UsuarioEntity donador = new UsuarioEntity();

    @OneToOne
    @JoinColumn(name = "FK_ID_USUARIO_ASIGNADO")
    public UsuarioEntity beneficiario;

    @JoinTable(
            name = "POSTULANTE",
            joinColumns = @JoinColumn(name = "FK_ID_DONATIVO", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_ID_USUARIO", nullable = false)
    )
    @OneToMany
    public List<PostulanteEntity> postulantes;

    public DonativoEntity() {
    }

    public DonativoEntity(Donativo donativo) {
        BeanUtils.copyProperties(donativo, this);
        BeanUtils.copyProperties(donativo.donador, this.donador);
    }

    public Donativo toDonativo() {
        Donativo donativo = new Donativo();
        BeanUtils.copyProperties(this, donativo);
//        BeanUtils.copyProperties(this.donador, donativo.donador);
        return donativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public UsuarioEntity getDonador() {
        return donador;
    }

    public void setDonador(UsuarioEntity donador) {
        this.donador = donador;
    }
}
