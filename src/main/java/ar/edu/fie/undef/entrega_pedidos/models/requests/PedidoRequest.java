package ar.edu.fie.undef.entrega_pedidos.models.requests;

import ar.edu.fie.undef.entrega_pedidos.models.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class PedidoRequest {

    public String comentarios;
    public String estado;
    public Vehiculo vehiculo;
    public Sucursal sucursal;
    public List<ProductoPedido> item;
    public Cliente cliente;
}
