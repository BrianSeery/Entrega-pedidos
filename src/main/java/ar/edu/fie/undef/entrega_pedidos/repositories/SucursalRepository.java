package ar.edu.fie.undef.entrega_pedidos.repositories;

import ar.edu.fie.undef.entrega_pedidos.models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    Optional<Sucursal> findByNombre(String nombre);
}
