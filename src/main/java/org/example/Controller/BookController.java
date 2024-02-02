package org.example.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Dto.Book;
import org.example.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class BookController {


    final BookService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        long startTime = System.currentTimeMillis();
        service.addBook(book);
        long auditTime = System.currentTimeMillis() - startTime;

        log.info("execution Time for add {}ms ",auditTime);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getBooks(){

        return service.getBooks();

    }

    @DeleteMapping("/delete{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        return service.delete(id) ? ResponseEntity.ok("Deleted"):ResponseEntity.notFound().build();
    }


    @GetMapping("search/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable Long id){
        return service.getBookById(id);
    }
}
