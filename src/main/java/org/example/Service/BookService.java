package org.example.Service;

import org.example.Dto.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    List<Book> getBooks();
}
