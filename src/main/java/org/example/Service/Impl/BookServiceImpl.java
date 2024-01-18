package org.example.Service.Impl;

import org.example.Dto.Book;
import org.example.Service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public boolean addBook(Book book) {
        return false;
    }
}
