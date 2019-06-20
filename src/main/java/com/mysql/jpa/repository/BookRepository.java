package com.mysql.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.mysql.jpa.pojo.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    

}
