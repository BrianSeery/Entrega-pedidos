package ar.edu.fie.undef.entrega_pedidos.models.requests;

import ar.edu.fie.undef.entrega_pedidos.models.Producto;
import lombok.Data;

@Data
public class ProductoRequest {

    private String fabrica;
    private String descripcion;
    private String color;
    private Double volumen;

    public ProductoRequest(
            String fabrica,
            String descripcion,
            String color,
            Double volumen
    ) {
        this.fabrica = fabrica;
        this.descripcion = descripcion;
        this.color = color;
        this.volumen = volumen;
    }

    public Producto construct() {
        return new Producto(fabrica, descripcion, color, volumen);
    }
}
