package ar.edu.fie.undef.entrega_pedidos.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {

        super(message);

    }

}
