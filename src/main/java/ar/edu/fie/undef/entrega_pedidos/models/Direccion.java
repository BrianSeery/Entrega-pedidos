package ar.edu.fie.undef.entrega_pedidos.models;

import ar.edu.fie.undef.entrega_pedidos.models.response.DireccionResponse;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private String numero;
    private String localidad;
    private String ciudad;
    private String provincia;

    public Direccion(
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

    public DireccionResponse representation() {
        return new DireccionResponse(
                id,
                calle,
                numero,
                localidad,
                ciudad,
                provincia
        );
    }
}

