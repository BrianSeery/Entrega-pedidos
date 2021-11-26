package ar.edu.fie.undef.entrega_pedidos.models.response;

import ar.edu.fie.undef.entrega_pedidos.models.Cliente;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ClienteResponse {

    private Long id;
    @NotNull
    private String mail;
    private String nombre;
    private String apellido;
    private String telefono;

    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
        this.mail = cliente.getMail();
        this.nombre = cliente.getNombre();
        this.telefono = cliente.getTelefono();
    }

}
