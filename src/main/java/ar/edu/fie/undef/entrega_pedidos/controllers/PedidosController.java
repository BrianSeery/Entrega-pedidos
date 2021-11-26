package ar.edu.fie.undef.entrega_pedidos.controllers;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.enums.Estado;
import ar.edu.fie.undef.entrega_pedidos.models.requests.PedidoRequest;
import ar.edu.fie.undef.entrega_pedidos.models.response.PedidoResponse;
import ar.edu.fie.undef.entrega_pedidos.services.PedidosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
public class PedidosController {

    private final PedidosService pedidosService;

    @PostMapping
    public ResponseEntity<PedidoResponse> crearPedido(
            @RequestBody
            PedidoRequest pedidoRequest
    ) throws CriticalException {
        System.out.println(pedidoRequest);
        return new ResponseEntity<>(
                new PedidoResponse(
                        this.pedidosService.crearPedido(
                                pedidoRequest
                        )
                ), HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> obtenerPedidos() {
        return new ResponseEntity<>(
                this.pedidosService.obtenerPedidos()
                        .stream()
                        .map(PedidoResponse::new)
                        .collect(Collectors.toList()
                        ), HttpStatus.OK
        );
    }

    @GetMapping("{idPedido}")
    public ResponseEntity<PedidoResponse> obtenerPedido(
            @PathVariable("idPedido") Long idPedido
    ) throws NotFoundException {
        return new ResponseEntity<>(
                new PedidoResponse(
                        this.pedidosService.obtenerPedidos(idPedido)
                ), HttpStatus.OK
        );
    }

    @PatchMapping("{idPedido}/vehiculo/{idVehiculo}")
    public ResponseEntity<PedidoResponse> asignarVehiculo(
            @PathVariable Long idPedido,
            @PathVariable Long idVehiculo
    ) throws NotFoundException {
        return new ResponseEntity<>(
                new PedidoResponse(
                        this.pedidosService.asignarVehiculo(idPedido, idVehiculo)
                ), HttpStatus.OK
        );
    }

    @PatchMapping("{idPedido}/estado/{enum}")
    public ResponseEntity<PedidoResponse> cambiarEstado(
            @PathVariable("idPedido") Long idPedido,
            @PathVariable("enum")Estado estado
            ) {
        return new ResponseEntity<>(
                new PedidoResponse(
                        this.pedidosService.cambiarEstado(idPedido, estado)
                ), HttpStatus.OK
        );

        //Patron Builder
//        return ResponseEntity.ok(
//                new PedidoResponse(this.pedidosService.cambiarEstado(idPedido, estado))
//        );
    }
}
