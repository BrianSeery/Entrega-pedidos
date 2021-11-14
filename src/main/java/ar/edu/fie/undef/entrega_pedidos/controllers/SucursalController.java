package ar.edu.fie.undef.entrega_pedidos.controllers;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.requests.SucursalRequest;
import ar.edu.fie.undef.entrega_pedidos.models.response.SucursalResponse;
import ar.edu.fie.undef.entrega_pedidos.services.SucursalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
        return new ResponseEntity<>(
                new SucursalResponse(
                        this.sucursalService.crearSucursal(
                                sucursalRequest
                        )
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/{idSucursal}")
    public ResponseEntity<SucursalResponse> obtenerSucursal(
            @PathVariable("idSucursal")
                    Long idSucursal
    ) throws NotFoundException {
        return new ResponseEntity<>(
                new SucursalResponse(
                        this.sucursalService.obtenerSucursal(idSucursal)
                )
                , HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<SucursalResponse>> obtenerSucursal() {
        return new ResponseEntity<>(
                this.sucursalService.obtenerSucursal()
                        .stream()
                        .map(SucursalResponse::new)
                        .collect(Collectors.toList())
                , HttpStatus.OK
        );
    }

    @DeleteMapping("/{idSucursal}")
    public ResponseEntity<HttpStatus> eliminarSucursal(
            @PathVariable("idSucursal")
                    Long idSucursal
    ) {
        this.sucursalService.eliminarSucursal(idSucursal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{idSucursal}")
    public ResponseEntity<SucursalResponse> actualizarSucursal(
            @PathVariable("idSucursal")
                    Long idSucursal,
            @RequestBody
                    SucursalRequest sucursalRequest
    ) throws NotFoundException {
        return new ResponseEntity<>(
                new SucursalResponse(
                        this.sucursalService.actualizarSucursal(
                                idSucursal,
                                sucursalRequest
                        )),
                HttpStatus.OK
        );
    }
}
