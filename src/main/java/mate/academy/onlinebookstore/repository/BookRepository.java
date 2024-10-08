package mate.academy.onlinebookstore.repository;

import mate.academy.onlinebookstore.model.Book;

import java.util.List;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
