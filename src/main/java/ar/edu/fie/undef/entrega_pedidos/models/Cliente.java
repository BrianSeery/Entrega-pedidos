package ar.edu.fie.undef.entrega_pedidos.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String mail;
    private String telefono;

    @OneToOne
    private Direccion direccion;

}
