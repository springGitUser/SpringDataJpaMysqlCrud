package com.mysql.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mysql.jpa.pojo.Book;
import com.mysql.jpa.service.BookService;

@RestController
@RequestMapping(value = { "/Book" })
public class BookController {
	@Autowired
	BookService BookService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getBookById(@PathVariable("id") long id) {
		System.out.println("Fetching Book with id " + id);
		Optional<Book> book = BookService.findById(id);
		if (book == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	    return new ResponseEntity<Object>(book, HttpStatus.OK);
		
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Void> createBook(@RequestBody Book Book, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Book " + Book.getName());
		BookService.createBook(Book);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/Book/{id}").buildAndExpand(Book.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/get")
	public List<Book> getAllBook() {
		List<Book> tasks = BookService.getBook();
		return tasks;

	}

	@PutMapping(value = "/update")
	public ResponseEntity<String> updateBook(@RequestBody Book currentBook) {
		System.out.println("sd");
		Optional<Book> Book = BookService.findById(currentBook.getId());
		if (Book == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		BookService.update(currentBook, currentBook.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") long id) {
		Optional<Book> Book = BookService.findById(id);
		if (Book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		BookService.deleteBookById(id);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}

}
