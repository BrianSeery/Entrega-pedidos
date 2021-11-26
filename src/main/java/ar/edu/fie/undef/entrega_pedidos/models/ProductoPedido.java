package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.requests.ProductoPedidoRequest;
import ar.edu.fie.undef.entrega_pedidos.services.ProductosService;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class ProductoPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;

    private int cantidad;

    @ManyToOne
    private Pedido pedido;

    public ProductoPedido(ProductoPedidoRequest productoPedidoRequest) {

        this.cantidad = productoPedidoRequest.getCantidad();
        this.producto = productoPedidoRequest.getProducto();

    }
}
