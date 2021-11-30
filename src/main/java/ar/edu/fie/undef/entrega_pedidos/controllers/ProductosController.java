package ar.edu.fie.undef.entrega_pedidos.controllers;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Producto;
import ar.edu.fie.undef.entrega_pedidos.models.requests.ProductoRequest;
import ar.edu.fie.undef.entrega_pedidos.models.response.ProductoResponse;
import ar.edu.fie.undef.entrega_pedidos.services.ProductosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductosController {

    private final ProductosService productosService;

    @PostMapping
    public ResponseEntity<ProductoResponse> crearProducto(
            @RequestBody
                    ProductoRequest productoRequest
    ) throws CriticalException {
        return ResponseEntity.ok(
                productosService
                        .crearProducto(productoRequest)
                        .representation()
        );
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> obtenerProducto() {
        return ResponseEntity.ok(
                this.productosService.obtenerProducto()
                        .stream()
                        .map(Producto::representation)
                        .collect(Collectors.toList()
                        )
        );
    }

    @GetMapping("{idProducto}")
    public ResponseEntity<ProductoResponse> obtenerProducto(
            @PathVariable("idProducto") Long idProducto
    ) throws NotFoundException {
        return ResponseEntity.ok(
                productosService
                        .obtenerProducto(idProducto)
                        .representation()
        );
    }

    @DeleteMapping("{idProducto}")
    public ResponseEntity<String> eliminarProducto(
            @PathVariable("idProducto")
                    Long idProducto
    ) throws NotFoundException {
        this.productosService.eliminarProducto(idProducto);
        return ResponseEntity.ok(
                "Prodcuto eliminado con exito"
        );
    }


}
