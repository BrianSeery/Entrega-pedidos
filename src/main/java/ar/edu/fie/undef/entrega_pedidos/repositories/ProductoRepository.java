package ar.edu.fie.undef.entrega_pedidos.repositories;

import ar.edu.fie.undef.entrega_pedidos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findByFabricaAndColor(
            String fabrica,
            String color
    );

    Optional<Producto> findByFabricaAndDescripcionAndColorAndVolumen(
            String fabrica,
            String descripcion,
            String color,
            Double volumen);
}
