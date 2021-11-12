package ar.edu.fie.undef.entrega_pedidos.controllers;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.requests.VehiculosRequest;
import ar.edu.fie.undef.entrega_pedidos.models.response.VehiculoResponse;
import ar.edu.fie.undef.entrega_pedidos.services.VehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController("/vehiculos")
public class VehiculosController {

    private final VehiculoService vehiculosService;

    @PostMapping
    public ResponseEntity<VehiculoResponse> crearVehiculo(
            @RequestBody
                    VehiculosRequest vehiculosRequest
    ) throws CriticalException {
        return new ResponseEntity<>(
                new VehiculoResponse(
                        this.vehiculosService.crearVehiculo(
                                vehiculosRequest
                        )
                )
                , HttpStatus.CREATED
        );

    }

    @GetMapping("/{idVehiculo}")
    public ResponseEntity<VehiculoResponse> obtenerVehiculo(
            @PathVariable("idVehiculo") Long idVehiculo
    ) throws NotFoundException {

        return new ResponseEntity<>(
                new VehiculoResponse(
                        this.vehiculosService.obtenerVehiculo(idVehiculo)
                )
                , HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<VehiculoResponse>> obtenerVehiculo() {
        return new ResponseEntity<>(
                this.vehiculosService.obtenerVehiculo()
                        .stream()
                        .map(VehiculoResponse::new)
                        .collect(Collectors.toList())
                , HttpStatus.OK
        );
    }

    @DeleteMapping("/{idVehiculo}")
    public ResponseEntity<String> eliminarVehiculo(
            @PathVariable("idVehiculo")
                    Long idVehiculo
    ) {
        this.vehiculosService.eliminarVehiculo(idVehiculo);
        return new ResponseEntity<>(
                "Vehiculo eliminado con exito",
                HttpStatus.OK);
    }

    @PatchMapping("/{idVehiculo}")
    public ResponseEntity<VehiculoResponse> modificarVehiculo(
            @PathVariable("idVehiculo")
                    Long idVehiculo,
            @RequestBody
                    VehiculosRequest vehiculosRequest
    ) throws NotFoundException {

        return new ResponseEntity<>(
                new VehiculoResponse(
                        this.vehiculosService.modificarVehiculo(
                                idVehiculo,
                                vehiculosRequest
                        )
                ), HttpStatus.OK
        );
    }
}
