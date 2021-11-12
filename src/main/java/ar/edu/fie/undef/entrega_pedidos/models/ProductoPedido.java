package ar.edu.fie.undef.entrega_pedidos.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "producto_remesa")
public class ProductoPedido {

    @Id
    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;

    @Id
    @ManyToOne
    @JoinColumn(name = "remesa_id", referencedColumnName = "id")
    private Pedido pedido;

    @Column(name = "cantidad")
    private int cantidad;



}
