package com.mysql.jpa.service;
import java.util.List;
import java.util.Optional;

import com.mysql.jpa.pojo.*;

public interface BookService {
    public void createBook(Book Book);
    public List<Book> getBook();
    public Optional<Book> findById(long id);
    public Book update(Book Book, long l);
    public void deleteBookById(long id);
    
}