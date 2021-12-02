package ar.edu.fie.undef.entrega_pedidos.controllers;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Pedido;
import ar.edu.fie.undef.entrega_pedidos.models.requests.PedidoRequest;
import ar.edu.fie.undef.entrega_pedidos.models.response.PedidoResponse;
import ar.edu.fie.undef.entrega_pedidos.services.PedidosService;
import lombok.AllArgsConstructor;
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
        return ResponseEntity.ok(
                pedidosService
                        .crearPedido(pedidoRequest)
                        .representation()
        );
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> obtenerPedidos() {
        return ResponseEntity.ok(
                this.pedidosService.obtenerPedidos()
                        .stream()
                        .map(Pedido::representation)
                        .collect(Collectors.toList()
                        )
        );
    }

    @GetMapping("{idPedido}")
    public ResponseEntity<PedidoResponse> obtenerPedido(
            @PathVariable("idPedido") Long idPedido
    ) throws NotFoundException {
        return ResponseEntity.ok(
                pedidosService
                        .obtenerPedidos(idPedido)
                        .representation()
        );
    }

    @PatchMapping("{idPedido}/vehiculo/{idVehiculo}")
    public ResponseEntity<PedidoResponse> asignarVehiculo(
            @PathVariable Long idPedido,
            @PathVariable Long idVehiculo
    ) throws NotFoundException {
        return ResponseEntity.ok(
                pedidosService
                        .asignarVehiculo(idPedido, idVehiculo)
                        .representation()
        );
    }

    @PatchMapping("{idPedido}/desvincularVehiculo")
    public ResponseEntity<PedidoResponse> desvincularVehiculo(
            @PathVariable Long idPedido
    ) throws NotFoundException {
        return ResponseEntity.ok(
                pedidosService
                        .desvincularVehiculo(idPedido)
                        .representation()
        );
    }

    @PatchMapping("{idPedido}/entregado")
    public ResponseEntity<PedidoResponse> marcarEntregado(
            @PathVariable("idPedido") Long idPedido
    ) {
        return ResponseEntity.ok(
                pedidosService
                        .marcarEntregado(idPedido)
                        .representation()
        );
    }
}
