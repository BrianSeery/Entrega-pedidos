package ar.edu.fie.undef.entrega_pedidos.models.requests;

import ar.edu.fie.undef.entrega_pedidos.models.Vehiculo;
import ar.edu.fie.undef.entrega_pedidos.services.ServicesRepository;
import ar.edu.fie.undef.entrega_pedidos.services.VehiculoService;
import lombok.Data;

@Data
public class VehiculosRequest {

    private final VehiculoService vehiculoService = ServicesRepository.find(VehiculoService.class);

    private String marca;
    private String modelo;
    private String patente;
    private Integer capacidad;
    private String chofer;

    public VehiculosRequest(
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

    public Vehiculo construct() {
        return vehiculoService
                .findByPatente(patente)
                .orElse( new Vehiculo(
                        marca,
                        modelo,
                        patente,
                        capacidad,
                        chofer
                ));
    }
}
