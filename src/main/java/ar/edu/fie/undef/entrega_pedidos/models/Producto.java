package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.response.ProductoResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Producto {
    //No Tocar

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String fabrica;
    private String descripcion;
    private String color;
    private Double volumen;

    public Producto(
            String fabrica,
            String descripcion,
            String color,
            Double volumen
    ){
        this.fabrica = fabrica;
        this.descripcion = descripcion;
        this.color = color;
        this.volumen = volumen;
    }

    public ProductoResponse representation() {
        return new ProductoResponse(
                id,
                fabrica,
                descripcion,
                color,
                volumen
        );
    }


}
