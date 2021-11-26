package ar.edu.fie.undef.entrega_pedidos.repositories;

import ar.edu.fie.undef.entrega_pedidos.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedido, Long> {

}
