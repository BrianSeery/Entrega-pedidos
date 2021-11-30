package ar.edu.fie.undef.entrega_pedidos.models.response;

import lombok.Data;

@Data
public class SucursalResponse {

    public Long id;
    public String nombre;

    public SucursalResponse(
            Long id,
            String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


}
