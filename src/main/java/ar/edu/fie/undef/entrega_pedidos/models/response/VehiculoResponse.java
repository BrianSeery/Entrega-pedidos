package ar.edu.fie.undef.entrega_pedidos.models.response;

import ar.edu.fie.undef.entrega_pedidos.models.Vehiculo;
import lombok.Data;

@Data
public class VehiculoResponse {

    public Long id;
    private String marca;
    private String modelo;
    private String patente;
    private String capacidad;
    private String chofer;

    public VehiculoResponse(Vehiculo vehiculo) {
        this.id = vehiculo.getId();
        this.marca = vehiculo.getMarca();
        this.modelo = vehiculo.getModelo();
        this.patente = vehiculo.getPatente();
        this.capacidad = vehiculo.getCapacidad();
        this.chofer = vehiculo.getChofer();
    }
}
