package com.wcs.ChallengeRest.repositories;

import com.wcs.ChallengeRest.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//Create et update
    Book save (Book book);
//    Select one
    Optional<Book> findById(Long id);

//    select all

    List<Book> findAll();
//    Delete
    void deleteById(Long id);

    // custom query to search to blog post by title or content
    List<Book> findByTitleContainingOrContentContaining(String text, String textAgain);
}
