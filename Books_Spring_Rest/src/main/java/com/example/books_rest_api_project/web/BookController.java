package com.example.books_rest_api_project.web;

import com.example.books_rest_api_project.model.dto.BookDTO;
import com.example.books_rest_api_project.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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



}
