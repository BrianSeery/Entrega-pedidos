package ar.edu.fie.undef.entrega_pedidos.models.requests;

import ar.edu.fie.undef.entrega_pedidos.models.Cliente;
import ar.edu.fie.undef.entrega_pedidos.models.Direccion;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ClienteRequest {

    @NotNull
    private String email;
    private String nombre;
    private String telefono;
    private DireccionRequest direccion;

    public ClienteRequest(
            String email,
            String nombre,
            String telefono,
            DireccionRequest direccion
    ) {
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente construct() {
        return new Cliente(
                email,
                nombre,
                telefono,
                direccion.construct()
        );
    }
}
