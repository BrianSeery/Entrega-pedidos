package ar.edu.fie.undef.entrega_pedidos.services.impl;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Sucursal;
import ar.edu.fie.undef.entrega_pedidos.models.requests.SucursalRequest;
import ar.edu.fie.undef.entrega_pedidos.repositories.SucursalRepository;
import ar.edu.fie.undef.entrega_pedidos.services.SucursalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;

    @Override
    public Sucursal crearSucursal(SucursalRequest sucursalRequest) throws CriticalException {

        Optional<Sucursal> sucursal = this.sucursalRepository.
                findByNombre(
                        sucursalRequest.getNombre()
                );
        if (sucursal.isPresent()){
            throw new CriticalException("Ya existe una sucursal con nombre " + sucursalRequest.getNombre());
        }
        return this.sucursalRepository.save(new Sucursal(sucursalRequest));
    }

    @Override
    public Sucursal obtenerSucursal(Long idSucursal) throws NotFoundException {
        return null;
    }

    @Override
    public Sucursal actualizarSucursal(Long idSucursal, SucursalRequest sucursalRequest) throws NotFoundException {
        return null;
    }

    @Override
    public Sucursal actualizarSucursal(Sucursal sucursal) {
        return null;
    }

    @Override
    public void eliminarSucursal(Long idSucursal) throws NotFoundException {

    }
}
