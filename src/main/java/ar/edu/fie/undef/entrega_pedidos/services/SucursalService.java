package ar.edu.fie.undef.entrega_pedidos.services;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Sucursal;
import ar.edu.fie.undef.entrega_pedidos.models.requests.SucursalRequest;

import java.util.List;
import java.util.Optional;

public interface SucursalService {

    Sucursal crearSucursal(SucursalRequest sucursalRequest) throws CriticalException;

    Sucursal obtenerSucursal(Long idSucursal) throws NotFoundException;

    List<Sucursal> obtenerSucursal();

    Sucursal actualizarSucursal(Long idSucursal, SucursalRequest sucursalRequest) throws NotFoundException;

    void eliminarSucursal(Long idSucursal) throws NotFoundException;

    Optional<Sucursal> findByNombre(String nombre);

    long count();

    List<Sucursal> saveAll(List<Sucursal> sucursalList);
}
