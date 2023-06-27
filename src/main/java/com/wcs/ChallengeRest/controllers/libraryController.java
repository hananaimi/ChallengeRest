package com.wcs.ChallengeRest.controllers;
import com.wcs.ChallengeRest.entities.Book;
import com.wcs.ChallengeRest.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class libraryController {
    @Autowired
    private BookRepository bookRepository;

//       CRUD Create Read Update Delete

//      Update and create
    @PostMapping ("/book")
    public Book save(@RequestBody Book book){
        return bookRepository.save(book);
    }

//    Read All
    @GetMapping("/books")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }
//    Read one
    @GetMapping("/book/{id}")
    public Optional<Book> findById(@PathVariable Long id){
        return bookRepository.findById(id);
    }


//      delete
    @DeleteMapping ("/book/delete/{id}")
    public void deleteById(@PathVariable Long id){
        bookRepository.deleteById(id);
    }

    @PostMapping("/book/search")
    public List<Book> search(@RequestBody Map <String, String> body){
        String searchTerm = body.get("text");
        return bookRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }


}
