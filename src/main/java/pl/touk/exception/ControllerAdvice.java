package pl.touk.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse validationException(ValidationException ex) {
        log.error("NOT_FOUND", ex);
        return new ErrorResponse(ex.getMessage(), ex.getErrors());
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse notFound(RecordNotFoundException ex) {
        log.error("NOT_FOUND", ex);
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse internal(Throwable ex) {
        log.error("INTERNAL_SERVER_ERROR", ex);
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse wrongParameter(IllegalArgumentException ex) {
        log.error("BAD_REQUEST", ex);
        return new ErrorResponse(ex.getMessage());
    }
}
