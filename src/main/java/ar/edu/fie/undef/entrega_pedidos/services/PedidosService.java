package ar.edu.fie.undef.entrega_pedidos.services;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Pedido;
import ar.edu.fie.undef.entrega_pedidos.models.requests.PedidoRequest;

import java.util.List;

public interface PedidosService {

    Pedido crearPedido(PedidoRequest pedidoRequest) throws CriticalException;

    List<Pedido> obtenerPedidos();

    Pedido obtenerPedidos(Long idPedido) throws NotFoundException;

    Pedido asignarVehiculo(Long idPedido, Long idVehiculo) throws NotFoundException;

    Pedido desvincularVehiculo(Long idPedido) throws NotFoundException;

    Pedido marcarEntregado(Long idPedido);
}
