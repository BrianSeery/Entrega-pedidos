package ar.edu.fie.undef.entrega_pedidos.models.requests;

import ar.edu.fie.undef.entrega_pedidos.models.Pedido;
import ar.edu.fie.undef.entrega_pedidos.models.enums.Estado;
import ar.edu.fie.undef.entrega_pedidos.models.enums.Origen;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PedidoRequest {

    public Estado estado;
    public Origen origen;
    public VehiculosRequest vehiculo;
    public ClienteRequest cliente;
    public SucursalRequest sucursal;
    public String comentarios;
    public List<ProductoPedidoRequest> productoPedido;

    public PedidoRequest(
            Estado estado,
            Origen origen,
            ClienteRequest cliente,
            SucursalRequest sucursal,
            String comentarios,
            List<ProductoPedidoRequest> productoPedido
    ) {
        this.estado = estado;
        this.origen = origen;
        this.cliente = cliente;
        this.sucursal = sucursal;
        this.comentarios = comentarios;
        this.productoPedido = productoPedido;
    }

    public Pedido construct() {
        return new Pedido(
                estado,
                origen,
                cliente.construct(),
                sucursal.construct(),
                comentarios,
                productoPedido
                        .stream()
                        .map(ProductoPedidoRequest::construct)
                        .collect(Collectors.toList())
        );
    }
}
