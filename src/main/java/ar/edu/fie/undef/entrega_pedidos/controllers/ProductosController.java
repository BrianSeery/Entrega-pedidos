package ar.edu.fie.undef.entrega_pedidos.controllers;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.requests.ProductoRequest;
import ar.edu.fie.undef.entrega_pedidos.models.response.ProductoResponse;
import ar.edu.fie.undef.entrega_pedidos.services.ProductosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
        return new ResponseEntity<>(
                new ProductoResponse(
                        this.productosService.crearProducto(
                                productoRequest
                        )
                ), HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> obtenerProducto() {
        return new ResponseEntity<>(
                this.productosService.obtenerProducto()
                        .stream()
                        .map(ProductoResponse::new)
                        .collect(Collectors.toList()
                        ), HttpStatus.OK
        );
    }

    @GetMapping("{idProducto}")
    public ResponseEntity<ProductoResponse> obtenerProducto(
            @PathVariable("idProducto") Long idProducto
    ) throws NotFoundException {
        return new ResponseEntity<>(
                new ProductoResponse(
                        this.productosService.obtenerProducto(idProducto)
                ), HttpStatus.OK
        );
    }

    @DeleteMapping("{idProducto}")
    public ResponseEntity<String> eliminarProducto(
            @PathVariable("idProducto")
                    Long idProducto
    ) throws NotFoundException {
        this.productosService.eliminarProducto(idProducto);
        return new ResponseEntity<>(
                "Prodcuto eliminado con exito",
                HttpStatus.OK
        );
    }


}
