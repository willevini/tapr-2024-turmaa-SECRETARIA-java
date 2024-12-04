package br.univille.microservsecretaria.comum.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetalhes> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        ErrorDetalhes errorDetalhes = new ErrorDetalhes(LocalDateTime.now(), "Validação falhou", errors);
        return new ResponseEntity<>(errorDetalhes, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetalhes> handleGlobalException(Exception ex, WebRequest request) {
        log.error("Application ERROR: ", ex);
        ErrorDetalhes errorDetalhes = new ErrorDetalhes(LocalDateTime.now(), "Erro inesperado.", null);
        return new ResponseEntity<>(errorDetalhes, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

