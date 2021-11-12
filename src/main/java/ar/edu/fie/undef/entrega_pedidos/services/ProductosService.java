package ar.edu.fie.undef.entrega_pedidos.services;

import ar.edu.fie.undef.entrega_pedidos.exceptions.CriticalException;
import ar.edu.fie.undef.entrega_pedidos.exceptions.NotFoundException;
import ar.edu.fie.undef.entrega_pedidos.models.Producto;
import ar.edu.fie.undef.entrega_pedidos.models.requests.ProductoRequest;

import java.util.List;

public interface ProductosService {

    Producto crearProducto(ProductoRequest productoRequest) throws CriticalException;

    List<Producto> obtenerProducto();

    Producto obtenerProducto(Long idProdcuto) throws NotFoundException;

    void eliminarProducto(Long idProdcuto) throws NotFoundException;
}
