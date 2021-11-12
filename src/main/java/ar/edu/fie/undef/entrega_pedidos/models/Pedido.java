package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.requests.PedidoRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comentarios;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @OneToMany(mappedBy = "pedido")
    private List<ProductoPedido> productoPedido;

    @OneToOne
    private Cliente cliente;

    public Pedido(PedidoRequest pedidoRequest) {
        this.comentarios = pedidoRequest.getComentarios();
        this.estado = pedidoRequest.getEstado();
        this.vehiculo = pedidoRequest.getVehiculo();
        this.productoPedido = pedidoRequest.getItem();
    }

}
