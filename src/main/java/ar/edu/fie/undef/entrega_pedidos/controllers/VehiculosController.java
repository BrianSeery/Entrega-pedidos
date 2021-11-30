package ar.edu.fie.undef.entrega_pedidos.controllers;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Vehiculo;
import ar.edu.fie.undef.entrega_pedidos.models.requests.VehiculosRequest;
import ar.edu.fie.undef.entrega_pedidos.models.response.VehiculoResponse;
import ar.edu.fie.undef.entrega_pedidos.services.VehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/vehiculos")
@AllArgsConstructor
public class VehiculosController {

    private final VehiculoService vehiculosService;

    @PostMapping
    public ResponseEntity<VehiculoResponse> crearVehiculo(
            @RequestBody
                    VehiculosRequest vehiculosRequest
    ) throws CriticalException {
        return ResponseEntity.ok(
                vehiculosService.
                        crearVehiculo(vehiculosRequest)
                        .representation()
        );
    }

    @GetMapping("/{idVehiculo}")
    public ResponseEntity<VehiculoResponse> obtenerVehiculo(
            @PathVariable("idVehiculo") Long idVehiculo
    ) throws NotFoundException {
        return ResponseEntity.ok(
                vehiculosService
                        .obtenerVehiculo(idVehiculo)
                        .representation()
        );
    }

    @GetMapping
    public ResponseEntity<List<VehiculoResponse>> obtenerVehiculo() {
        return ResponseEntity.ok(
                this.vehiculosService.obtenerVehiculo()
                        .stream()
                        .map(Vehiculo::representation)
                        .collect(Collectors.toList())
        );
    }

    @DeleteMapping("/{idVehiculo}")
    public ResponseEntity<String> eliminarVehiculo(
            @PathVariable("idVehiculo")
                    Long idVehiculo
    ) {
        this.vehiculosService.eliminarVehiculo(idVehiculo);
        return ResponseEntity.ok(
                "Vehiculo eliminado con exito");
    }

    @PatchMapping("/{idVehiculo}")
    public ResponseEntity<VehiculoResponse> modificarVehiculo(
            @PathVariable("idVehiculo")
                    Long idVehiculo,
            @RequestBody
                    VehiculosRequest vehiculosRequest
    ) throws NotFoundException {
        return ResponseEntity.ok(
                vehiculosService.modificarVehiculo(
                        idVehiculo,
                        vehiculosRequest
                ).representation()
        );
    }
}
