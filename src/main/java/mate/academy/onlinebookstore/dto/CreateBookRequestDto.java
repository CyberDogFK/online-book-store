package mate.academy.onlinebookstore.dto;

import java.math.BigDecimal;

public record CreateBookRequestDto(
        String title,
        String author,
        String isbn,
        BigDecimal price,
        String description,
        String coverImage) {
}
