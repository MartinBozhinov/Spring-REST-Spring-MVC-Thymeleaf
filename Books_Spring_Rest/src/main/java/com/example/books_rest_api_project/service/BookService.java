package com.example.books_rest_api_project.service;

import com.example.books_rest_api_project.model.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAll();

}
