package org.example.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Dto.Book;
import org.example.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
@RequiredArgsConstructor
public class BookController {


    final BookService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        long startTime = System.currentTimeMillis();
        service.addBook(book);
        long auditTime = System.currentTimeMillis() - startTime;

        log.info("execution Time for add {}ms ",auditTime);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getBooks(){

        return service.getBooks();
        
    }
}
