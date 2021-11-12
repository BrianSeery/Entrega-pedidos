package ar.edu.fie.undef.entrega_pedidos.models.response;

import ar.edu.fie.undef.entrega_pedidos.models.*;
import lombok.Data;

import java.util.List;

@Data
public class PedidoResponse {

    public Long id;
    public String comentarios;
    public String estado;
    public Vehiculo vehiculo;
    public List<ProductoPedido> item;
    public Cliente cliente;

    public PedidoResponse(Pedido pedido){
        this.id = pedido.getId();
        this.comentarios = pedido.getComentarios();
        this.estado = pedido.getEstado();
        this.vehiculo = pedido.getVehiculo();
        this.item = pedido.getProductoPedido();
        this.cliente = pedido.getCliente();
    }
}
