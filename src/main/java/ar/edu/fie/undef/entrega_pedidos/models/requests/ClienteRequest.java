package ar.edu.fie.undef.entrega_pedidos.models.requests;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ClienteRequest {

    @NotNull
    private String email;
    private String nombre;
    private String telefono;

}
