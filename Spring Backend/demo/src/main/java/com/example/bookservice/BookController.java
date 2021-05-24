package com.example.bookservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    
    @Autowired
    private BookRepository repository;


    @PostMapping("book")
    public ResponseEntity<Book> postBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.OK).body(this.repository.save(book));
    }

    @GetMapping("book/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id) {
        Optional<Book> book = this.repository.findById(id);
        
        if(book.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(book.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Not Found");
        }
       
    }

    @GetMapping("books/author/{author}")
    public ResponseEntity<?> getBooksByAuthor(@PathVariable String author) {
        List<Book> books = this.repository.findByAuthor(author);
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping("books")
    public ResponseEntity<?> getAllBooks() {
        Iterable<Book> books = this.repository.findAll();
        List<Book> booklist = new ArrayList<Book>();

        books.iterator().forEachRemaining(booklist::add);

        return ResponseEntity.status(HttpStatus.OK).body(booklist);
    }
    
}
