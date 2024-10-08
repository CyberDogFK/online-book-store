package mate.academy.onlinebookstore.service;

import mate.academy.onlinebookstore.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
