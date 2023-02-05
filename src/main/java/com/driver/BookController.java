package com.driver;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    // get book by Id
    @GetMapping("get-book-by-id/{id}")
    public ResponseEntity getBook(@PathVariable("id") String id){

        Book response = bookService.findBookById(id);
        return new ResponseEntity<>(response , HttpStatus.ACCEPTED);
    }

    public ResponseEntity getAllBook(){

        List<Book> list=bookService.findAllBooks();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/get-books-by-author")
    public ResponseEntity getBookByAuthor(@RequestParam("q") String author){

        List<Book> list = new ArrayList<>();
        list = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(list , HttpStatus.OK);

    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity getBookByGenre(@RequestParam("q") String genre){

        List<Book> list = new ArrayList<>();
        list = bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(list , HttpStatus.OK);
    }

    @DeleteMapping("delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") String id){

        bookService.deleteBookById(id);
        return new ResponseEntity<>("Delete successful" , HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBook(){

        bookService.deleteAllBooks();
        return new ResponseEntity<>("Delete successful" , HttpStatus.OK);
    }
}
