package ar.edu.fie.undef.entrega_pedidos.models.response;

import ar.edu.fie.undef.entrega_pedidos.models.Pedido;
import lombok.Data;

@Data
public class ProductoPedidoResponse {

    public Long id;
    public Integer cantidad;
    public Pedido pedido;


    public ProductoPedidoResponse(
            Long id,
            Integer cantidad,
            Pedido pedido
    ) {
        this.id = id;
        this.cantidad = cantidad;
        this.pedido = pedido;
    }

}
