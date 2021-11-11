package com.nology.FirstAPI.rest;


import com.nology.FirstAPI.entity.Book;
import com.nology.FirstAPI.entity.Message;
import com.nology.FirstAPI.exception.InvalidRequestDataException;
import com.nology.FirstAPI.exception.ResourceNotFoundException;
import com.nology.FirstAPI.repository.IBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private IBooksRepository booksRepo;
    // goes to the interface - creates a class for it and injects it -> dependency injection -> without it this is just an
    // unitialised class.

    @GetMapping
    public ResponseEntity<List<Book>> allBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(booksRepo.findAll());
    }

    // For show, use findById
    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable int id) throws ResourceNotFoundException {
        Book book = booksRepo.findById(id).orElse(null);
        if (book == null) throw new ResourceNotFoundException("No recipe found with id: " + id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }



    // CREATE
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) throws InvalidRequestDataException {
        try {
            Book newBook = booksRepo.save(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
        } catch (Exception e) {
            throw new InvalidRequestDataException("Incorrect request data.");
        }
    }
    // what does the e do in (Exception e)?


    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) throws ResourceNotFoundException {
        checkIfExists(id);
        book.setId(id);
        booksRepo.save(book);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deleteBook(@PathVariable int id) throws ResourceNotFoundException {
        checkIfExists(id);
        booksRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Message("Successfully deleted."));
    }



    // CHECK BOOK EXISTS METHOD
    private void checkIfExists(int id) throws ResourceNotFoundException {
        Book existingBook = booksRepo.findById(id).orElse(null);
        if (existingBook == null) throw new ResourceNotFoundException("No recipe found with id: " + id);
    }


}
