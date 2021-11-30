package ar.edu.fie.undef.entrega_pedidos.services;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Vehiculo;
import ar.edu.fie.undef.entrega_pedidos.models.requests.VehiculosRequest;

import java.util.List;
import java.util.Optional;

public interface VehiculoService {

    Vehiculo crearVehiculo(
            VehiculosRequest vehiculosRequest
    ) throws CriticalException;

    List<Vehiculo> obtenerVehiculo();

    Vehiculo obtenerVehiculo(Long idVehiculo) throws NotFoundException;

    void eliminarVehiculo(Long idVehiculo) throws NotFoundException;

    Vehiculo modificarVehiculo(
            Long idVehiculo,
            VehiculosRequest vehiculosRequest
    ) throws NotFoundException;

    Optional<Vehiculo> findByPatente(String patente);
}
