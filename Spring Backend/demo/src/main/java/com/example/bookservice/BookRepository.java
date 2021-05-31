package com.example.bookservice;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);

    @Query(value = "Select * From Books Where LOWER(author) = LOWER(?1)", nativeQuery = true)
    List<Book> findByAuthor(String author);
}
