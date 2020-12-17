package cl.bitsoft.vicky.domain.models.donativo;

import cl.bitsoft.vicky.domain.models.usuario.Usuario;

import java.util.List;

public class Donativo {
    public Long          id;
    public String        titulo;
    public Integer       cantidad;
    public List<Usuario> postulantes;
    public Usuario       donador;
    public Usuario       beneficiario;

    public Donativo(Long id, String titulo, Integer cantidad) {
        this.id = id;
        this.titulo = titulo;
        this.cantidad = cantidad;
    }

    public Donativo() {
        this.donador = new Usuario();
        this.beneficiario = new Usuario();
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

    @Override
    public String toString() {
        return "Donativo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
