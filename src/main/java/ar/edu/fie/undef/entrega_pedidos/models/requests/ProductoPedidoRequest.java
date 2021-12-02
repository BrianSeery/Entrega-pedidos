package ar.edu.fie.undef.entrega_pedidos.models.requests;

import ar.edu.fie.undef.entrega_pedidos.models.ProductoPedido;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductoPedidoRequest {

    public Integer cantidad;
    public ProductoRequest producto;

    public ProductoPedidoRequest(
            Integer cantidad,
            ProductoRequest producto
    ) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public ProductoPedido construct() {
        return new ProductoPedido(
                cantidad,
                producto.construct());
    }
}
