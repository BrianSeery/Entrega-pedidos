package ar.edu.fie.undef.entrega_pedidos.services.impl;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Sucursal;
import ar.edu.fie.undef.entrega_pedidos.models.requests.SucursalRequest;
import ar.edu.fie.undef.entrega_pedidos.repositories.SucursalRepository;
import ar.edu.fie.undef.entrega_pedidos.services.SucursalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;

    @Override
    public Sucursal crearSucursal(
            SucursalRequest sucursalRequest
    ) throws CriticalException {
        return this.sucursalRepository.save(sucursalRequest.construct());
    }

    @Override
    public Sucursal obtenerSucursal(Long idSucursal) throws NotFoundException {
        return this.sucursalRepository.findById(idSucursal)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Sucursal> obtenerSucursal() {
        return this.sucursalRepository.findAll();
    }

    @Override
    public Sucursal actualizarSucursal(
            Long idSucursal,
            SucursalRequest sucursalRequest
    ) throws NotFoundException {
        Sucursal sucursal = this.obtenerSucursal(idSucursal);
        if (Objects.nonNull(sucursalRequest.getNombre()))
            sucursal.setNombre(sucursalRequest.getNombre());
        return this.sucursalRepository.save(sucursal);
    }

    @Override
    public void eliminarSucursal(Long idSucursal) throws NotFoundException {
        Sucursal sucursal = this.obtenerSucursal(idSucursal);
        this.sucursalRepository.delete(sucursal);

    }

    @Override
    public Optional<Sucursal> findByNombre(String nombre) {
        return sucursalRepository.findByNombre(nombre);
    }

    @Override
    public long count() {
        return sucursalRepository.countAllBy();
    }

    @Override
    public List<Sucursal> saveAll(List<Sucursal> sucursalList) {
        return sucursalRepository.saveAll(sucursalList);
    }
}
