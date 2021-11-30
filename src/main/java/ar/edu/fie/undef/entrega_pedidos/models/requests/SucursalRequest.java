package ar.edu.fie.undef.entrega_pedidos.models.requests;

import ar.edu.fie.undef.entrega_pedidos.models.Sucursal;
import ar.edu.fie.undef.entrega_pedidos.services.ServicesRepository;
import ar.edu.fie.undef.entrega_pedidos.services.SucursalService;
import lombok.Data;

@Data
public class SucursalRequest {

    private final SucursalService sucursalService = ServicesRepository.find(SucursalService.class);

    private String nombre;

    public SucursalRequest(
            String nombre
    ) {
        this.nombre = nombre;
    }

    public SucursalRequest(){}

    public Sucursal construct() {
        return sucursalService
                .findByNombre(nombre)
                .orElse( new Sucursal(
                        nombre
                ));
    }

}
