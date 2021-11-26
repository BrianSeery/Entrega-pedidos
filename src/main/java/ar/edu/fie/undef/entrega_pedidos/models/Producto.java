package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.requests.ProductoRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    public Producto(ProductoRequest productoRequest) {
        this.fabrica = productoRequest.getFabrica();
        this.descripcion = productoRequest.getDescripcion();
        this.color = productoRequest.getColor();
    }
}
