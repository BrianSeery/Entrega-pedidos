package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.response.ClienteResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String mail;
    private String telefono;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Direccion direccion;

    public Cliente(
            String nombre,
            String mail,
            String telefono,
            Direccion direccion
    ) {
        this.nombre = nombre;
        this.mail = mail;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public ClienteResponse representation() {
        return new ClienteResponse(id, nombre, mail, telefono, direccion);
    }

}
