package com.example.books_rest_api_project.web;

import com.example.books_rest_api_project.model.dto.BookDTO;
import com.example.books_rest_api_project.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.desktop.OpenFilesEvent;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
      List<BookDTO> books = this.bookService.getAll();

      return ResponseEntity.ok(books);

    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") long id){

        Optional<BookDTO> book = this.bookService.findById(id);

        if (book.isEmpty()){
            return ResponseEntity.notFound()
                    .build();
        }else{
            return ResponseEntity.ok(book.get());
        }
    }


    @PutMapping()
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO
            , UriComponentsBuilder uriComponentsBuilder){
        long bookId = bookService.createBook(bookDTO);

        URI location = uriComponentsBuilder.path("/books/{id}")
                .buildAndExpand(bookId).toUri();

        return ResponseEntity.created(location).build();


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> delete(@PathVariable("id") Long id){
        bookService.deleteBook(id);

        return ResponseEntity.noContent()
                .build();

    }




}
