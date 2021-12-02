package ar.edu.fie.undef.entrega_pedidos.services.impl;

import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Pedido;
import ar.edu.fie.undef.entrega_pedidos.models.Vehiculo;
import ar.edu.fie.undef.entrega_pedidos.models.enums.Estado;
import ar.edu.fie.undef.entrega_pedidos.models.requests.PedidoRequest;
import ar.edu.fie.undef.entrega_pedidos.repositories.PedidosRepository;
import ar.edu.fie.undef.entrega_pedidos.services.PedidosService;
import ar.edu.fie.undef.entrega_pedidos.services.VehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidosServiceImpl implements PedidosService {

    private final PedidosRepository pedidoRepository;
    private final VehiculoService vehiculoService;

    @Override
    public Pedido crearPedido(PedidoRequest pedidoRequest) {
        System.out.println(pedidoRequest);
        return this.pedidoRepository.save(pedidoRequest.construct());
    }

    @Override
    public List<Pedido> obtenerPedidos() {
        return this.pedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPedidos(
            Long idPedido
    ) throws NotFoundException {
        return this.pedidoRepository.findById(idPedido)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Pedido asignarVehiculo(Long idPedido, Long idVehiculo) throws NotFoundException {

        //TODO agregar logica de volumen del producto y capadidad del vehiculo.
        Pedido pedido = this.obtenerPedidos(idPedido);
        Vehiculo vehiculo = this.vehiculoService.obtenerVehiculo(idVehiculo);
        pedido.asignarVehiculo(vehiculo);
        pedido.setVehiculo(vehiculo);
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido cambiarEstado(Long idPedido, Estado estado) {
        Pedido pedido = this.obtenerPedidos(idPedido);
        pedido.actualizarEstado(estado);
        return this.pedidoRepository.save(pedido);
    }
}
