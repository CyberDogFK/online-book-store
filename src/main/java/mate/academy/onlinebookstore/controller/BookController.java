package mate.academy.onlinebookstore.controller;

import lombok.AllArgsConstructor;
import mate.academy.onlinebookstore.dto.BookDto;
import mate.academy.onlinebookstore.dto.CreateBookRequestDto;
import mate.academy.onlinebookstore.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @GetMapping("/inject")
    public void injectTestData() {
        // Change
        CreateBookRequestDto bookDto = new CreateBookRequestDto(
                "Harry Potter",
                "J.K. Rowling",
                "y",
                BigDecimal.ONE,
                "description",
                "coverImageUrl"
        );

        bookService.save(bookDto);

        bookService.findAll();
    }

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.findAll();
    }

    @GetMapping
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public BookDto createBook(@RequestBody CreateBookRequestDto bookRequestDto) {
        return bookService.save(bookRequestDto);
    }
}
