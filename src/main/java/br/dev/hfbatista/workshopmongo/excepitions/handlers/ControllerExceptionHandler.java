package br.dev.hfbatista.workshopmongo.excepitions.handlers;

import br.dev.hfbatista.workshopmongo.excepitions.StandardError;
import jakarta.servlet.http.HttpServletRequest;

import br.dev.hfbatista.workshopmongo.excepitions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException error, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado!", error.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
