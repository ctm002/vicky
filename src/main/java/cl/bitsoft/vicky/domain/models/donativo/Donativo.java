package cl.bitsoft.vicky.domain.models.donativo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "TBL_DONATIVO")
public class Donativo {

    @Column(name = "ID")
    @Id()
    public Long id;

    @Column(name = "NOMBRE")
    public String nombre;

    @Column(name = "CANTIDAD")
    public Integer cantidad;
    
}
