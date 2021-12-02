package ar.edu.fie.undef.entrega_pedidos.models.response;

import ar.edu.fie.undef.entrega_pedidos.models.Producto;
import lombok.Data;

@Data
public class ProductoPedidoResponse {

    public Long id;
    public Integer cantidad;
    public Producto producto;


    public ProductoPedidoResponse(
            Long id,
            Integer cantidad,
            Producto producto
    ) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
    }

}
