package ar.edu.fie.undef.entrega_pedidos.services.impl;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Vehiculo;
import ar.edu.fie.undef.entrega_pedidos.models.requests.VehiculosRequest;
import ar.edu.fie.undef.entrega_pedidos.repositories.VehiculoRepository;
import ar.edu.fie.undef.entrega_pedidos.services.VehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo crearVehiculo(
            VehiculosRequest vehiculosRequest
    ) throws CriticalException {
        Optional<Vehiculo> vehiculoOptional = this.vehiculoRepository.findByPatente(vehiculosRequest.getPatente());
        if (vehiculoOptional.isPresent())
            throw new CriticalException("Ya existe un vehiculo con esa patente " + vehiculosRequest.getPatente());

        return this.vehiculoRepository.save(new Vehiculo(vehiculosRequest));
    }

    @Override
    public Vehiculo obtenerVehiculo(
            Long idVehiculo
    ) throws NotFoundException {
        return this.vehiculoRepository.findById(idVehiculo)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public void eliminarVehiculo(
            Long idVehiculo
    ) throws NotFoundException {
        Vehiculo vehiculo = this.obtenerVehiculo(idVehiculo);
        this.vehiculoRepository.delete(vehiculo);
    }

    @Override
    public Vehiculo modificarVehiculo(
            Long idVehiculo,
            VehiculosRequest vehiculosRequest
    ) throws NotFoundException {

        Vehiculo vehiculo = this.obtenerVehiculo(idVehiculo);
        if (Objects.nonNull(vehiculosRequest.getMarca())) {
            vehiculo.setMarca(vehiculosRequest.getMarca());
        }
        if (Objects.nonNull(vehiculosRequest.getPatente())) {
            vehiculo.setPatente(vehiculosRequest.getPatente());
        }
        if (Objects.nonNull(vehiculosRequest.getModelo())) {
            vehiculo.setModelo(vehiculosRequest.getModelo());
        }
        if (Objects.nonNull(vehiculosRequest.getCapacidad())) {
            vehiculo.setCapacidad(vehiculosRequest.getCapacidad());
        }
        return this.vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> obtenerVehiculo() {
        return this.vehiculoRepository.findAll();
    }

}
