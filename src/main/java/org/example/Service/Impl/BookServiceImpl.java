package org.example.Service.Impl;

import org.example.Dto.Book;
import org.example.Repository.BookRepository;
import org.example.Service.BookService;
import org.example.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repository;


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
}
