package ar.edu.fie.undef.entrega_pedidos.models.requests;

import lombok.Data;

@Data
public class ProductoRequest {

    private String fabrica;
    private String linea;
    private String descripcion;
    private String tamanio;
    private String color;

}
