package cl.bitsoft.vicky.domain.models.usuario;

public class Usuario {
    private Long   id;
    private String nombres;

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

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombres + '\'' +
                '}';
    }

}
