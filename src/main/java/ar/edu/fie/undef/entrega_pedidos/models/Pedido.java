package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.enums.Estado;
import ar.edu.fie.undef.entrega_pedidos.models.enums.Origen;
import ar.edu.fie.undef.entrega_pedidos.models.response.PedidoResponse;
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

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    private Origen origen;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Sucursal sucursal;

    private String comentarios;

    @OneToMany(mappedBy="pedido" ,cascade = CascadeType.PERSIST)
    private List<ProductoPedido> productoPedido;

    public Pedido(
            Estado estado,
            Origen origen,
            Cliente cliente,
            Sucursal sucursal,
            String comentarios,
            List<ProductoPedido> productoPedidosRequest
    ) {
        this.estado = estado;
        this.origen = origen;
        this.cliente = cliente;
        this.sucursal = sucursal;
        this.comentarios = comentarios;
        this.productoPedido = productoPedidosRequest;
    }

    public PedidoResponse representation() {
        return new PedidoResponse(
                id,
                estado,
                origen,
                vehiculo,
                cliente,
                sucursal,
                comentarios,
                productoPedido
        );
    }

    public void asignarVehiculo(Vehiculo vehiculo) {
        vehiculo = vehiculo;
    }
}
