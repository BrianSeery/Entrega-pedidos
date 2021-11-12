package ar.edu.fie.undef.entrega_pedidos.models.response;

import ar.edu.fie.undef.entrega_pedidos.models.Sucursal;
import lombok.Data;

@Data
public class SucursalResponse {

    public Long id;
    public String nombre;

    public SucursalResponse(Sucursal sucursal) {

        this.id = sucursal.getId();
        this.nombre = sucursal.getNombre();

    }

}
