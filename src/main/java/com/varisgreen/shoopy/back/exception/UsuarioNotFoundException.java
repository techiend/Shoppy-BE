package com.varisgreen.shoopy.back.exception;

import java.text.MessageFormat;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(long id) {
        super(MessageFormat.format("No se encontro el usuario de id {0}",id));
    }
}
