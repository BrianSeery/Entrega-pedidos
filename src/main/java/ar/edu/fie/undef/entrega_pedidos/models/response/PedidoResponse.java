package ar.edu.fie.undef.entrega_pedidos.models.response;

import ar.edu.fie.undef.entrega_pedidos.models.Cliente;
import ar.edu.fie.undef.entrega_pedidos.models.ProductoPedido;
import ar.edu.fie.undef.entrega_pedidos.models.Sucursal;
import ar.edu.fie.undef.entrega_pedidos.models.Vehiculo;
import ar.edu.fie.undef.entrega_pedidos.models.enums.Estado;
import ar.edu.fie.undef.entrega_pedidos.models.enums.Origen;
import lombok.Data;

import java.util.List;

@Data
public class PedidoResponse {

    public Long id;
    public Estado estado;
    public Origen origen;
    public Vehiculo vehiculo;
    public Cliente cliente;
    public Sucursal sucursal;
    public String comentarios;
    public List<ProductoPedido> productoPedido;

    public PedidoResponse(
            Long id,
            Estado estado,
            Origen origen,
            Vehiculo vehiculo,
            Cliente cliente,
            Sucursal sucursal,
            String comentarios,
            List<ProductoPedido> productoPedido
    ){
        this.id = id;
        this.estado = estado;
        this.origen = origen;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.sucursal = sucursal;
        this.comentarios = comentarios;
        this.productoPedido = productoPedido;
    }
}
