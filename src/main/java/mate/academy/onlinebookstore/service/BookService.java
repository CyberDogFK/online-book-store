package mate.academy.onlinebookstore.service;

import java.util.List;
import java.util.Optional;
import mate.academy.onlinebookstore.dto.BookDto;
import mate.academy.onlinebookstore.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    List<BookDto> findAll();

    Optional<BookDto> findById(Long id);
}
