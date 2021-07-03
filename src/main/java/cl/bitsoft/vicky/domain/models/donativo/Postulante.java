package cl.bitsoft.vicky.domain.models.donativo;

import cl.bitsoft.vicky.domain.models.usuario.Usuario;

import java.time.LocalDateTime;

public class Postulante {
    private Usuario       usuario;
    private LocalDateTime fecha;
    private int           estado;

    public Postulante() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
