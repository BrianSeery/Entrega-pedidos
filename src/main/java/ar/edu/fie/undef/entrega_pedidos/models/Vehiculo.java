package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.requests.VehiculosRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String marca;
    private String modelo;
    private String patente;
    private String capacidad;
    private String chofer;

    @OneToMany(mappedBy = "vehiculo")
    private List<Pedido> pedidos;

    public Vehiculo(VehiculosRequest vehiculosRequest) {
        this.marca = vehiculosRequest.getMarca();
        this.modelo = vehiculosRequest.getModelo();
        this.patente = vehiculosRequest.getPatente();
        this.capacidad = vehiculosRequest.getCapacidad();
        this.chofer = vehiculosRequest.getChofer();
    }

}
