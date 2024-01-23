package org.example.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.Dto.Book;
import org.example.Repository.BookRepository;
import org.example.Service.BookService;
import org.example.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {


    final BookRepository repository;


    ModelMapper modelMapper;


    @Bean
    public void setUp(){
        modelMapper=new ModelMapper();
    }

    @Override
    public void addBook(Book book) {
        BookEntity entity = modelMapper.map(book, BookEntity.class);
        repository.save(entity);
    }

    @Override
    public List<Book> getBooks() {
        Iterable<BookEntity> allBooks = repository.findAll();

        List<Book> bookList=new ArrayList<>();

        for (BookEntity book:allBooks) {
            bookList.add(
                    modelMapper.map(book,Book.class)
            );
        }

        return bookList;
    }
}
