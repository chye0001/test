package ccy.kapsejlaldsbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SejlbådNotFound.class)
    public ResponseEntity<Error> handleSejlbådNotFoundException(SejlbådNotFound exception) {
        Error error = new Error(HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(KapsejladsNotFound.class)
    public ResponseEntity<Error> handleKapsejladsNotFoundException(KapsejladsNotFound exception) {
        Error error = new Error(HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
