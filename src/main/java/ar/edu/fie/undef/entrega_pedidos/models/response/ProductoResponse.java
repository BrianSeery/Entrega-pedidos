package ar.edu.fie.undef.entrega_pedidos.models.response;

import ar.edu.fie.undef.entrega_pedidos.models.Producto;
import lombok.Data;

@Data
public class ProductoResponse {

    public Long id;
    public String fabrica;
    public String descripcion;
    public String color;

    public ProductoResponse(Producto producto) {
        this.id = producto.getId();
        this.fabrica = producto.getFabrica();
        this.descripcion = producto.getDescripcion();
        this.color = producto.getColor();
    }

}
