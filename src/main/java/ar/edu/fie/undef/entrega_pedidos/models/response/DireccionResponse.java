package ar.edu.fie.undef.entrega_pedidos.models.response;

import ar.edu.fie.undef.entrega_pedidos.models.Direccion;
import lombok.Data;

@Data
public class DireccionResponse {

    public String calle;
    public String numero;
    public String localidad;
    public String ciudad;
    public String provincia;

    public DireccionResponse(Direccion direccion) {
        this.calle = direccion.getCalle();
        this.numero = direccion.getNumero();
        this.localidad = direccion.getLocalidad();
        this.provincia = direccion.getProvincia();
    }
}
