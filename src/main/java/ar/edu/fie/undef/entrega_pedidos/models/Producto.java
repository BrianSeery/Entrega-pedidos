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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fabrica;
    private String linea;
    private String descripcion;
    private String tamanio;
    private String color;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "productoPedido_id")
    private List<ProductoPedido> productoPedido;

    public Producto(ProductoRequest productoRequest) {
        this.fabrica = productoRequest.getFabrica();
        this.linea = productoRequest.getLinea();
        this.descripcion = productoRequest.getDescripcion();
        this.tamanio = productoRequest.getTamanio();
        this.color = productoRequest.getColor();
    }
}
