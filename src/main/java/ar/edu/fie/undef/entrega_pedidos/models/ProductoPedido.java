package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.response.ProductoPedidoResponse;
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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;

    private Integer cantidad;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Pedido pedido;

    public ProductoPedido(
            Integer cantidad,
            Producto producto
    ) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public ProductoPedidoResponse representation() {
        return new ProductoPedidoResponse(
                id,
                cantidad,
                pedido
        );
    }
}
