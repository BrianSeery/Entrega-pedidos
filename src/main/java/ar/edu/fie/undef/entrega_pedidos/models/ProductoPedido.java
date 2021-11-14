package ar.edu.fie.undef.entrega_pedidos.models;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "producto_remesa")
public class ProductoPedido implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Id
    @ManyToOne
    @JoinColumn(name = "remesa_id")
    private Pedido pedido;

    @Column(name = "cantidad")
    private int cantidad;



}
