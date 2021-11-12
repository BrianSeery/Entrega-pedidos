package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.requests.DireccionRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String calle;
    private String numero;
    private String localidad;
    private String ciudad;
    private String provincia;

    public Direccion(DireccionRequest direccionRequest) {
        this.calle = direccionRequest.getCalle();
        this.numero = direccionRequest.getNumero();
        this.localidad = direccionRequest.getLocalidad();
        this.ciudad = direccionRequest.getCiudad();
        this.provincia = direccionRequest.getProvincia();
    }
}

