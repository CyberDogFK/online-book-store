package mate.academy.onlinebookstore.exception;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatusCode;

public record CustomErrorResponse(
        List<String> errors,
        LocalDateTime timestamp,
        HttpStatusCode status
) {
}
