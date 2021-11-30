package ar.edu.fie.undef.entrega_pedidos.models.response;

import ar.edu.fie.undef.entrega_pedidos.models.Direccion;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ClienteResponse {

    private Long id;
    @NotNull
    private String mail;
    private String nombre;
    private String telefono;
    private Direccion direccion;

    public ClienteResponse(
            Long id,
            String mail,
            String nombre,
            String telefono,
            Direccion direccion
    ) {
        this.id = id;
        this.mail = mail;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

}
