package ar.edu.fie.undef.entrega_pedidos.models.response;

import ar.edu.fie.undef.entrega_pedidos.models.*;
import ar.edu.fie.undef.entrega_pedidos.models.enums.Estado;
import ar.edu.fie.undef.entrega_pedidos.models.enums.Origen;
import lombok.Data;

import java.util.List;

@Data
public class PedidoResponse {

    public Long id;
    public String comentarios;
    public Estado estado;
    public Origen origen;
    public Vehiculo vehiculo;
    public Cliente cliente;
    public Sucursal sucursal;

    public PedidoResponse(Pedido pedido){
        this.id = pedido.getId();
        this.comentarios = pedido.getComentarios();
        this.estado = pedido.getEstado();
        this.origen = pedido.getOrigen();
        this.vehiculo = pedido.getVehiculo();
        this.cliente = pedido.getCliente();
        this.sucursal = pedido.getSucursal();
    }
}
