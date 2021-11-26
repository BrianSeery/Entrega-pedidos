package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.enums.Estado;
import ar.edu.fie.undef.entrega_pedidos.models.enums.Origen;
import ar.edu.fie.undef.entrega_pedidos.models.requests.PedidoRequest;
import ar.edu.fie.undef.entrega_pedidos.models.requests.ProductoPedidoRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    private Origen origen;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.MERGE)
    private Sucursal sucursal;

    private String comentarios;

    @OneToMany(mappedBy="pedido" ,cascade = CascadeType.PERSIST)
    private List<ProductoPedido> productoPedidos;

    public Pedido(PedidoRequest pedidoRequest) {
        this.estado = pedidoRequest.getEstado();
        this.origen = pedidoRequest.getOrigen();
        this.vehiculo = pedidoRequest.getVehiculo();
        this.cliente = pedidoRequest.getCliente();
        this.sucursal = pedidoRequest.getSucursal();
        this.comentarios = pedidoRequest.getComentarios();
        this.productoPedidos = pedidoRequest.getProductoPedido()
                .stream()
                .map(ProductoPedido::new)
                .collect(Collectors.toList());
    }

    public void asignarVehiculo(Vehiculo vehiculo) {
        vehiculo = vehiculo;
    }

}
