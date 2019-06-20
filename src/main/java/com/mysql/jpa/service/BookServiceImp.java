package com.mysql.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jpa.pojo.*;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    com.mysql.jpa.repository.BookRepository BookRepository;

    public void createBook(Book Book) {
        // TODO Auto-generated method stub
        BookRepository.save(Book);
    }

    public List<Book> getBook() {
        // TODO Auto-generated method stub
        return (List<Book>) BookRepository.findAll();
    }

    public Optional<Book> findById(long id) {
        // TODO Auto-generated method stub
        return BookRepository.findById(id);
    }

    public Book update(Book Book, long l) {
        // TODO Auto-generated method stub
        return BookRepository.save(Book);
    }

    public void deleteBookById(long id) {
        // TODO Auto-generated method stub
        BookRepository.deleteById(id);
    }

    
}