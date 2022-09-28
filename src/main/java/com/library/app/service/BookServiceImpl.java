package com.library.app.service;

import com.library.app.model.Book;
import com.library.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book saveBok(Book b) {
        return bookRepository.save(b);
    }

    @Override
    public Book findBookByID(Long id) {
        Optional<Book> searchBook = bookRepository.findById(id);
        Book book = null;
        if(searchBook.isPresent()){
            book= bookRepository.findById(id).get();
        }
        return book;
    }

    @Override
    public Book findBookByAuthor(String author) {
        return null;
    }

    @Override
    public Book findBookByTitle(String title) {
        return null;
    }

    @Override
    public Book findBookBySubject(String subject) {
        return null;
    }

    @Override
    public void deleteBookByID(Long id) {
        Optional<Book> searchBook = bookRepository.findById(id);
        if(searchBook.isPresent()){
            bookRepository.deleteById(id);
        }
    }

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book b) {
        return bookRepository.save(b);
    }
}
