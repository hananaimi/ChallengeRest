package com.wcs.ChallengeRest.controllers;
import com.wcs.ChallengeRest.entities.Book;
import com.wcs.ChallengeRest.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class libraryController {
    @Autowired
    private BookRepository bookRepository;

//      create
    @PostMapping ("/books")
    public Book save(@RequestBody Book book){
        return bookRepository.save(book);
    }
//    update
    @PutMapping ("/books/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book){
        Book updatedBook= bookRepository.findById(id).get();
        updatedBook.setTitle(book.getTitle());
        updatedBook.setDescription( book.getDescription());
        updatedBook.setAuthor(book.getAuthor());
        return bookRepository.save(updatedBook);
    }

//    Select All
    @GetMapping("/books")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }
//    Select one by id
    @GetMapping("/books/{id}")
    public Book findById(@PathVariable Long id){
        return bookRepository.findById(id).get();
    }
//      delete
    @DeleteMapping ("/book/delete/{id}")
    public void deleteById(@PathVariable Long id){
        bookRepository.deleteById(id);
    }

    @PostMapping("/books/search")
    public List<Book> searchBook (@RequestBody   Map <String, String> body){
        String searchTermTitle = body.get("searchTermTitle");
        String searchTermDesc = body.get("searchTermDesc");
        return bookRepository.findByTitleContainingOrDescriptionContaining(searchTermTitle, searchTermDesc );
    }

}
