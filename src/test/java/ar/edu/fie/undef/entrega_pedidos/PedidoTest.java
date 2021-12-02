package ar.edu.fie.undef.entrega_pedidos;

import static ar.edu.fie.undef.entrega_pedidos.models.enums.Estado.*;
import static org.junit.jupiter.api.Assertions.*;

import ar.edu.fie.undef.entrega_pedidos.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ar.edu.fie.undef.entrega_pedidos.models.enums.Origen.DEPOSITO;

public class PedidoTest {

    @Nested
    @DisplayName("Given un pedido sin asignar")
    class GivenUnPedidoSinAsignar {

        @Nested
        @DisplayName("When es asignado a un vehiculo")
        class WhenSinAsignar {

            @Test
            @DisplayName("Then su estado debe cambiar a asignado y debe indicar a que vehiculo esta asociado")
            void ThenSuestadoDebeCambiarAsignadoYDebeIndicarAQueVehiculoEstaAsociado() {
                //given
                Direccion direccion = new Direccion(
                        "Donado",
                        "3836",
                        "Saavedra",
                        "CABA",
                        "Buenos Aires"
                );
                Cliente cliente = new Cliente(
                        "Brian",
                        "seeryabrin@gmail.com",
                        "1131922119",
                        direccion
                );
                Sucursal sucursal = new Sucursal(
                        "Pampa"
                );
                Producto producto = new Producto(
                        "Samsung",
                        "televisor",
                        "negro",
                        80.0
                );
                List<ProductoPedido> productoPedidos = new ArrayList<>();
                productoPedidos.add(new ProductoPedido(
                        1,
                        producto
                ));
                Pedido pedido = new Pedido(
                        PENDIENTE,
                        DEPOSITO,
                        cliente,
                        sucursal,
                        "Entregar al mediodia",
                        productoPedidos
                );
                Vehiculo vehiculo = new Vehiculo(
                        "Fiat",
                        "Fiorino",
                        "asd123",
                        100,
                        "mario"
                );

                //when
                pedido.asignarVehiculo(vehiculo);

                //then
                Assertions.assertEquals(pedido.getEstado(), ASIGNADO);
                Assertions.assertNotNull(pedido.getVehiculo());
            }
        }
    }

    @Nested
    @DisplayName("Given un pedido de 60 de volumen")
    class GivenUnPedidoDe60DeVolumen {

        @Nested
        @DisplayName("When es asignado a un vehiculo con capacidad para 100")
        class WhenEsAsignadoAUnVehiculoConCapacidadPara100 {

            @Test
            @DisplayName("Then Se debe poder asignar")
            void ThenSeDebePoderAsignar() {
                //given
                Direccion direccion = new Direccion(
                        "Donado",
                        "3836",
                        "Saavedra",
                        "CABA",
                        "Buenos Aires"
                );
                Cliente cliente = new Cliente(
                        "Brian",
                        "seeryabrin@gmail.com",
                        "1131922119",
                        direccion
                );
                Sucursal sucursal = new Sucursal(
                        "Pampa"
                );
                Producto producto = new Producto(
                        "Sinteplat",
                        "recuplast frentes",
                        "blanco",
                        20.0
                );
                List<ProductoPedido> productoPedidos = new ArrayList<>();
                productoPedidos.add(new ProductoPedido(
                        3,
                        producto
                ));
                Pedido pedido = new Pedido(
                        PENDIENTE,
                        DEPOSITO,
                        cliente,
                        sucursal,
                        "Entregar al mediodia",
                        productoPedidos
                );
                Vehiculo vehiculo = new Vehiculo(
                        "Fiat",
                        "Fiorino",
                        "asd123",
                        100,
                        "mario"
                );

                //when
                pedido.asignarVehiculo(vehiculo);

                //then
                Assertions.assertEquals(pedido.getEstado(), ASIGNADO);
                Assertions.assertNotNull(pedido.getVehiculo());
            }
        }
    }

    @Nested
    @DisplayName("Given un pedido asignado")
    class GivenUnPedidoAsignado {

        @Nested
        @DisplayName("When no es podido entregar, vuelve a deposito")
        class WhenNoEsPodidoEntregar {

            @Test
            @DisplayName("Then cambia estado y se le quita vehiculo")
            void ThenCambiaElEstadoYseLeQuitaElVehiculo() {
                //given
                Direccion direccion = new Direccion(
                        "Donado",
                        "3836",
                        "Saavedra",
                        "CABA",
                        "Buenos Aires"
                );
                Cliente cliente = new Cliente(
                        "Brian",
                        "seeryabrin@gmail.com",
                        "1131922119",
                        direccion
                );
                Sucursal sucursal = new Sucursal(
                        "Pampa"
                );
                Producto producto = new Producto(
                        "Sinteplat",
                        "recuplast frentes",
                        "blanco",
                        20.0
                );
                List<ProductoPedido> productoPedidos = new ArrayList<>();
                productoPedidos.add(new ProductoPedido(
                        3,
                        producto
                ));
                Pedido pedido = new Pedido(
                        PENDIENTE,
                        DEPOSITO,
                        cliente,
                        sucursal,
                        "Entregar al mediodia",
                        productoPedidos
                );
                Vehiculo vehiculo = new Vehiculo(
                        "Fiat",
                        "Fiorino",
                        "asd123",
                        100,
                        "mario"
                );
                pedido.asignarVehiculo(vehiculo);

                //when
                pedido.desvincularVehiculo();

                //then
                Assertions.assertEquals(pedido.getEstado(), PENDIENTE);
                Assertions.assertNull(pedido.getVehiculo());
            }
        }
    }

    @Nested
    @DisplayName("Given pedido de volumen 120")
    class GivenUnPedidoDeVolumen120 {

        @Nested
        @DisplayName("When asignado a vehiculo de capacidad 100")
        class WhenAsignadoAVehiculodeCapacidad100 {

            @Test
            @DisplayName("Then Lanza una excepcion")
            void ThenLanzaUnaExcepcion() {
                //given
                Direccion direccion = new Direccion(
                        "Donado",
                        "3836",
                        "Saavedra",
                        "CABA",
                        "Buenos Aires"
                );
                Cliente cliente = new Cliente(
                        "Brian",
                        "seeryabrin@gmail.com",
                        "1131922119",
                        direccion
                );
                Sucursal sucursal = new Sucursal(
                        "Pampa"
                );
                Producto producto = new Producto(
                        "Sinteplat",
                        "recuplast frentes",
                        "blanco",
                        20.0
                );
                List<ProductoPedido> productoPedidos = new ArrayList<>();
                productoPedidos.add(new ProductoPedido(
                        6,
                        producto
                ));
                Pedido pedido = new Pedido(
                        PENDIENTE,
                        DEPOSITO,
                        cliente,
                        sucursal,
                        "Entregar al mediodia",
                        productoPedidos
                );
                Vehiculo vehiculo = new Vehiculo(
                        "Fiat",
                        "Fiorino",
                        "asd123",
                        100,
                        "mario"
                );

                //then
                Exception exception = assertThrows(RuntimeException.class, () -> {
                    pedido.asignarVehiculo(vehiculo);
                });

                //then
                String expectedMessage = "Capacidad de vehiculo excedida";
                String actualMessage = exception.getMessage();
                assertTrue(actualMessage.contains(expectedMessage));
            }
        }
    }

    @Nested
    @DisplayName("Given pedido entregado")
    class GivenUnPedidoEntregado {

        @Nested
        @DisplayName("When cambio de estado")
        class WhenCambioDeEstado {

            @Test
            @DisplayName("Then Lanza una excepcion")
            void ThenLanzaUnaExcepcion() {
                //given
                Direccion direccion = new Direccion(
                        "Donado",
                        "3836",
                        "Saavedra",
                        "CABA",
                        "Buenos Aires"
                );
                Cliente cliente = new Cliente(
                        "Brian",
                        "seeryabrin@gmail.com",
                        "1131922119",
                        direccion
                );
                Sucursal sucursal = new Sucursal(
                        "Pampa"
                );
                Producto producto = new Producto(
                        "Sinteplat",
                        "recuplast frentes",
                        "blanco",
                        20.0
                );
                List<ProductoPedido> productoPedidos = new ArrayList<>();
                productoPedidos.add(new ProductoPedido(
                        6,
                        producto
                ));
                Pedido pedido = new Pedido(
                        PENDIENTE,
                        DEPOSITO,
                        cliente,
                        sucursal,
                        "Entregar al mediodia",
                        productoPedidos
                );
                Vehiculo vehiculo = new Vehiculo(
                        "Fiat",
                        "Fiorino",
                        "asd123",
                        200,
                        "mario"
                );
                pedido.asignarVehiculo(vehiculo);
                pedido.actualizarEstado(ENTREGADO);
                //then
                Exception exception = assertThrows(RuntimeException.class, () -> {
                    pedido.actualizarEstado(PENDIENTE);
                });

                //then
                String expectedMessage = "Un pedido entregado no puede cambiar de estado";
                String actualMessage = exception.getMessage();
                assertTrue(actualMessage.contains(expectedMessage));
            }
        }
    }
}
