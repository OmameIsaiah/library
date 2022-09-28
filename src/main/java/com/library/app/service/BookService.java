package com.library.app.service;

import com.library.app.model.Book;

import java.util.List;

public interface BookService {
    Book saveBok(Book b);
    Book findBookByID(Long id);
    Book findBookByAuthor(String author);
    Book findBookByTitle(String title);
    Book findBookBySubject(String subject);
    void deleteBookByID(Long id);
    List<Book> findAllBook();
    Book updateBook(Book b);
}
