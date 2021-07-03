package cl.bitsoft.vicky.adapters.mysql.usuario;

import cl.bitsoft.vicky.adapters.mysql.donativo.entities.DonativoEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "TBL_USUARIO")
public class UsuarioEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name="NOMBRES")
    private String nombres;

    @Column(name="APELLIDO_PATERNO")
    private String apellidoPaterno;

    @Column(name="APELLIDO_MATERNO")
    private String apellidoMaterno;

    @Column(name="RUT")
    private String rut;

//    @Enumerated(EnumType.STRING)
    @Column(name="GENERO")
    private String genero;

    @Column(name="FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;

//    @OneToMany(mappedBy = "donador")
//    private List<DonativoEntity> donativos;

//    @OneToMany(mappedBy = "beneficiario")
//    private List<DonativoEntity> asignaciones;

    public UsuarioEntity(){}

    public UsuarioEntity(Long id,  String nombres, String apellidoPaterno, String apellidoMaterno, String rut, String genero) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rut = rut;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombres='" + nombres + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", rut='" + rut + '\'' +
//                ", genero='" + genero + '\'' +
                '}';
    }
}
