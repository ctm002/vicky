package cl.bitsoft.vicky.domain.models.donativo;

import cl.bitsoft.vicky.domain.models.usuario.Usuario;

import java.util.List;

public class Donativo {
    public Long          id;
    public String        nombre;
    public Integer       cantidad;
    public List<Usuario> postulantes;
    public Usuario       donador;
    public Usuario       beneficiario;

    public Donativo(Long id, String nombre, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
