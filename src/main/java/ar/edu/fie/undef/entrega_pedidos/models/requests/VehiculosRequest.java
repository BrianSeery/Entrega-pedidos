package ar.edu.fie.undef.entrega_pedidos.models.requests;

import lombok.Data;

@Data
public class VehiculosRequest {

    private String marca;
    private String modelo;
    private String patente;
    private String capacidad;
    private String chofer;
}
