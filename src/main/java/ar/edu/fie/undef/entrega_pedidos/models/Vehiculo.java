package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.response.VehiculoResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private Integer capacidad;
    private String chofer;

    public Vehiculo(
            String marca,
            String modelo,
            String patente,
            Integer capacidad,
            String chofer
            ) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.capacidad = capacidad;
        this.chofer = chofer;
    }

    public VehiculoResponse representation() {
        return new VehiculoResponse(id, marca, modelo, patente, capacidad, chofer);
    }

}
