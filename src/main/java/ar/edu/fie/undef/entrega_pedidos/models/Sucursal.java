package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.response.SucursalResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    public Sucursal(String nombre) {
        this.nombre = nombre;
    }

    public SucursalResponse representation() {
        return new SucursalResponse(id, nombre);
    }

}
