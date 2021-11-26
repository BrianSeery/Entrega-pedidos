package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.requests.ClienteRequest;
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

    public Cliente(ClienteRequest clienteRequest) {
        this.mail = clienteRequest.getEmail();
        this.nombre = clienteRequest.getNombre();
        this.telefono = clienteRequest.getTelefono();
    }

}
