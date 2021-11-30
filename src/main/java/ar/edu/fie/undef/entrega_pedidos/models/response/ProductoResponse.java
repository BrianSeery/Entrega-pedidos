package ar.edu.fie.undef.entrega_pedidos.models.response;

import lombok.Data;

@Data
public class ProductoResponse {

    public Long id;
    public String fabrica;
    public String descripcion;
    public String color;
    public Double volumen;

    public ProductoResponse(
            Long id,
            String fabrica,
            String descripcion,
            String color,
            Double volumen
    ) {
        this.id = id;
        this.fabrica = fabrica;
        this.descripcion = descripcion;
        this.color = color;
        this.volumen = volumen;
    }

}
