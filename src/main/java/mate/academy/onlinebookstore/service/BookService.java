package mate.academy.onlinebookstore.service;

import java.util.List;
import mate.academy.onlinebookstore.dto.BookDto;
import mate.academy.onlinebookstore.dto.BookSearchParametersDto;
import mate.academy.onlinebookstore.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto updateById(CreateBookRequestDto book, Long id);

    void deleteById(Long id);

    List<BookDto> searchBooks(BookSearchParametersDto searchParameters);
}
