package ar.edu.fie.undef.entrega_pedidos.models.requests;


import ar.edu.fie.undef.entrega_pedidos.models.Direccion;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DireccionRequest {

    public String calle;
    public String numero;
    public String localidad;
    public String ciudad;
    public String provincia;

    public DireccionRequest(
            String calle,
            String numero,
            String localidad,
            String ciudad,
            String provincia
    ) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

    public Direccion construct() {
        return new Direccion(
                calle,
                numero,
                localidad,
                ciudad,
                provincia
        );
    }

}
