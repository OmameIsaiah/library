package com.library.app.controller;

import com.library.app.model.Book;
import com.library.app.response.ApiOutput;
import com.library.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    BookService service;

    @GetMapping("/books")
    List<Book> findAllBooks() {
        return service.findAllBook();
    }

    @GetMapping("/book/{id}")
    Book findBookByID(@PathVariable("id") Long id) {
        return service.findBookByID(id);
    }

    @DeleteMapping("/book/{id}")
    void deleteBook(@PathVariable("id") Long id) {
        service.deleteBookByID(id);
    }

    @PutMapping("/updateBook")
    ResponseEntity<Book> updateBook(@RequestBody @Valid Book b) {
        Book book = service.updateBook(b);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/saveBook")
    ResponseEntity<ApiOutput> saveBook(@RequestBody @Valid Book b) {
        Book book = service.saveBok(b);
        ApiOutput output = new ApiOutput();
        output.setCode(200);
        output.setData(book);
        output.setResponse("Book saved successfully!");
        return ResponseEntity.ok().body(output);
    }

}
