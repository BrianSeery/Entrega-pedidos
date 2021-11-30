package ar.edu.fie.undef.entrega_pedidos.models.response;

import lombok.Data;

@Data
public class VehiculoResponse {

    public Long id;
    public String marca;
    public String modelo;
    public String patente;
    public Integer capacidad;
    public String chofer;

    public VehiculoResponse(
            Long id,
            String marca,
            String modelo,
            String patente,
            Integer capacidad,
            String chofer) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.capacidad = capacidad;
        this.chofer = chofer;
    }
}
