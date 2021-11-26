package ar.edu.fie.undef.entrega_pedidos.models.requests;

import ar.edu.fie.undef.entrega_pedidos.models.*;
import ar.edu.fie.undef.entrega_pedidos.models.enums.Estado;
import ar.edu.fie.undef.entrega_pedidos.models.enums.Origen;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class PedidoRequest {

    public Estado estado;
    public Origen origen;
    public Vehiculo vehiculo;
    public Cliente cliente;
    public Sucursal sucursal;
    public String comentarios;
    public List<ProductoPedidoRequest> productoPedido;
}
