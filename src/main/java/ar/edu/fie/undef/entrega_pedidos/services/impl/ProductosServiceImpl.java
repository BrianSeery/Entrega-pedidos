package ar.edu.fie.undef.entrega_pedidos.services.impl;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Producto;
import ar.edu.fie.undef.entrega_pedidos.models.requests.ProductoRequest;
import ar.edu.fie.undef.entrega_pedidos.repositories.ProductoRepository;
import ar.edu.fie.undef.entrega_pedidos.services.ProductosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductosServiceImpl implements ProductosService {

    private final ProductoRepository productoRepository;

    @Override
    public Producto crearProducto(
            ProductoRequest productoRequest
    ) throws CriticalException {
        Optional<Producto> productoOptional = this.productoRepository.
                findByFabricaAndColor(
                        productoRequest.getFabrica(),
                        productoRequest.getColor()
                );
        if (productoOptional.isPresent()) {
            throw new CriticalException("Ya existe un producto con esas caracteristicas");
        }
        return this.productoRepository.save(productoRequest.construct());
    }

    @Override
    public List<Producto> obtenerProducto() {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto obtenerProducto(
            Long idProdcuto
    ) throws NotFoundException {
        return this.productoRepository.findById(idProdcuto)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public void eliminarProducto(Long idProdcuto) throws NotFoundException {
        Producto producto = this.obtenerProducto(idProdcuto);
        this.productoRepository.delete(producto);
    }

    @Override
    public Optional<Producto> findByFabricaAndDescripcionAndColorAndVolumen(String fabrica, String descripcion, String color, Double volumen) {
        return productoRepository.findByFabricaAndDescripcionAndColorAndVolumen(
                fabrica,
                descripcion,
                color,
                volumen
        );
    }
}
