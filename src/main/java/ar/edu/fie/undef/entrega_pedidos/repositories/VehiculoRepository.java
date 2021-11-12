package ar.edu.fie.undef.entrega_pedidos.repositories;

import ar.edu.fie.undef.entrega_pedidos.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    Optional<Vehiculo> findByPatente(String patente);
}
