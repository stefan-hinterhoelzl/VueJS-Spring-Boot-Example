package com.example.bookservice;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);

    @Query("Select b From Books Where LOWER(author) = LOWER(:author)")
    List<Book> findByAuthor(@Param("author") String author);


}
