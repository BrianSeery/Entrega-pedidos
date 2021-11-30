package ar.edu.fie.undef.entrega_pedidos.controllers;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Sucursal;
import ar.edu.fie.undef.entrega_pedidos.models.requests.SucursalRequest;
import ar.edu.fie.undef.entrega_pedidos.models.response.SucursalResponse;
import ar.edu.fie.undef.entrega_pedidos.services.SucursalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/sucursales")
@AllArgsConstructor
public class SucursalController {

    private final SucursalService sucursalService;

    @PostMapping
    public ResponseEntity<SucursalResponse> crearSucursal(
            @RequestBody
                    SucursalRequest sucursalRequest
    ) throws CriticalException {
        return ResponseEntity.ok(
                sucursalService
                        .crearSucursal(sucursalRequest)
                        .representation()
        );
    }

    @GetMapping("/{idSucursal}")
    public ResponseEntity<SucursalResponse> obtenerSucursal(
            @PathVariable("idSucursal")
                    Long idSucursal
    ) throws NotFoundException {
        return ResponseEntity.ok(
                sucursalService
                        .obtenerSucursal(idSucursal)
                        .representation()
        );
    }

    @GetMapping
    public ResponseEntity<List<SucursalResponse>> obtenerSucursal() {
        return ResponseEntity.ok(
                sucursalService.obtenerSucursal()
                        .stream()
                        .map(Sucursal::representation)
                        .collect(Collectors.toList())
        );
    }

    @DeleteMapping("/{idSucursal}")
    public ResponseEntity<String> eliminarSucursal(
            @PathVariable("idSucursal")
                    Long idSucursal
    ) {
        this.sucursalService.eliminarSucursal(idSucursal);
        return ResponseEntity.ok("Sucursal eliminada correctamente");
    }

    @PutMapping("/{idSucursal}")
    public ResponseEntity<SucursalResponse> actualizarSucursal(
            @PathVariable("idSucursal")
                    Long idSucursal,
            @RequestBody
                    SucursalRequest sucursalRequest
    ) throws NotFoundException {
        return ResponseEntity.ok(
                sucursalService
                        .actualizarSucursal(idSucursal, sucursalRequest)
                        .representation()
        );
    }
}
