package com.example.books_rest_api_project.service;

import com.example.books_rest_api_project.model.dto.BookDTO;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDTO> getAll();

    Optional<BookDTO> findById(long id);

}
