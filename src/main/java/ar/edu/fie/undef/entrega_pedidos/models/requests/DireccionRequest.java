package ar.edu.fie.undef.entrega_pedidos.models.requests;


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

}
