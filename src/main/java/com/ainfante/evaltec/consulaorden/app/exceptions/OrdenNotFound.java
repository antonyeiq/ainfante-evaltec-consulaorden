package com.ainfante.evaltec.consulaorden.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Orden no encontrada")
public class OrdenNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;

}
