package ar.edu.fie.undef.entrega_pedidos.models.requests;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class SucursalRequest {

    @NotNull
    private String nombre;

}
