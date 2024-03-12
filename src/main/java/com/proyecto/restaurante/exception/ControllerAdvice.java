package com.proyecto.restaurante.exception;

import com.proyecto.restaurante.dto.ErrorDto;
import com.proyecto.restaurante.exception.StringContainsNumberException;
import com.proyecto.restaurante.exception.UppercaseInStringException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RestControllerAdvice(annotations = RestController.class)
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> HandlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        LocalDateTime timestamp = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

        List<String> detalles = e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        ErrorDto error = new ErrorDto("p-400", "Error de validacion", detalles, timestamp);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(StringContainsNumberException.class)
    public ResponseEntity<?> stringContainsNumberException(StringContainsNumberException e){
        LocalDateTime timestamp = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        ErrorDto error = ErrorDto.builder().code("p-404")
                .debugMessage("!ERROR! no se permiten numeros en el nombre").time(timestamp).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(UppercaseInStringException.class)
    public ResponseEntity<?> uppercaseInStringException(UppercaseInStringException e){
        LocalDateTime timestamp = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        ErrorDto error = ErrorDto.builder().code("p-406")
                .debugMessage("La contraseña debe contener al menos una mayuscula").time(timestamp).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(EmptyInventoryException.class)
    public ResponseEntity<?> EmptyInventoryException(EmptyInventoryException e){
        LocalDateTime timestamp = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        ErrorDto error = ErrorDto.builder().code("p-408")
                .debugMessage("No hay suficiente materia prima").time(timestamp).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(IdComidaNotFoundException.class)
    public ResponseEntity<?> IdComidaNotFoundException(IdComidaNotFoundException e){
        LocalDateTime timestamp = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        ErrorDto error = ErrorDto.builder().code("p-413")
                .debugMessage(e.getMessage()).time(timestamp).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(AmountNegativeException.class)
    public ResponseEntity<?> AmountNegativeException(AmountNegativeException e){
        LocalDateTime timestamp = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        ErrorDto error = ErrorDto.builder().code("p-412")
                .debugMessage("No esta permitido ingresar cantidades negativas").time(timestamp).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ExistEmailException.class)
    public ResponseEntity<?> handlerExistEmailException(ExistEmailException e) {
        LocalDateTime timestamp = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        ErrorDto error = ErrorDto.builder().code("p-414")
                .debugMessage("No esta permitido ingresar un email ya existente").time(timestamp).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
