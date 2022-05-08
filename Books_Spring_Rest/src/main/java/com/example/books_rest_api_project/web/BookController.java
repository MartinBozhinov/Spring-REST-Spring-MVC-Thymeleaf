package com.example.books_rest_api_project.web;

import com.example.books_rest_api_project.model.dto.BookDTO;
import com.example.books_rest_api_project.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.desktop.OpenFilesEvent;
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




}
