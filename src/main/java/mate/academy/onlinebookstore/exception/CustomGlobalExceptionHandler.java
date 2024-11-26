package mate.academy.onlinebookstore.exception;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        var errors = ex.getBindingResult().getAllErrors().stream()
                .map(this::getValidatorErrorMessage)
                .toList();
        return new ResponseEntity<>(
                new CustomErrorResponse(errors, LocalDateTime.now(), status), status);
    }

    @Override
    protected ResponseEntity<Object> handleNoResourceFoundException(
            NoResourceFoundException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        return new ResponseEntity<>(
                new CustomErrorResponse(List.of(ex.getMessage()), LocalDateTime.now(), status),
                headers,
                status);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundExceptions(EntityNotFoundException ex) {
        var status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(
                new CustomErrorResponse(List.of(ex.getMessage()), LocalDateTime.now(), status),
                status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(
                new CustomErrorResponse(List.of(ex.getMessage()), LocalDateTime.now(), status),
                status);
    }

    private String getValidatorErrorMessage(ObjectError e) {
        if (e instanceof FieldError) {
            String field = ((FieldError) e).getField();
            String message = e.getDefaultMessage();
            return field + ": " + message;
        }
        return e.getDefaultMessage();
    }

    private List<String> getCauseErrorMessages(Throwable ex) {
        List<Throwable> errors = List.of(ex);
        Throwable err = ex.getCause();
        while (err != null) {
            err = err.getCause();
        }
        return errors.stream()
                .map(Throwable::getMessage)
                .toList();
    }
}
