package ar.edu.fie.undef.entrega_pedidos.models.response;

import lombok.Data;

@Data
public class DireccionResponse {

    public Long id;
    public String calle;
    public String numero;
    public String localidad;
    public String ciudad;
    public String provincia;

    public DireccionResponse(
            Long id,
            String calle,
            String numero,
            String localidad,
            String ciudad,
            String provincia
    ) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }
}
