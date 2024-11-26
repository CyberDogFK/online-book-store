package mate.academy.onlinebookstore.exception;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatusCode;

public record CustomErrorResponse(
        List<String> errors,
        LocalDateTime timestamp,
        HttpStatusCode status
) {
    public static CustomErrorResponse of(List<String> errors, HttpStatusCode status) {
        return new CustomErrorResponse(errors, LocalDateTime.now(), status);
    }
}
