package com.example.books_rest_api_project.service;

import com.example.books_rest_api_project.model.dto.AuthorDTO;
import com.example.books_rest_api_project.model.dto.BookDTO;
import com.example.books_rest_api_project.model.entity.BookEntity;
import com.example.books_rest_api_project.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
  private final BookRepository bookRepository;
  private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookDTO> getAll() {

        return this.bookRepository.findAll().stream().
                map(this::asBook).collect(Collectors.toList());


    }

    @Override
    public Optional<BookDTO> findById(long id) {
        return this.bookRepository.findById(id)
                .map(this::asBook);
    }

    public BookDTO asBook(BookEntity book){
     BookDTO bookDTO = this.modelMapper.map(book,BookDTO.class);
     AuthorDTO authorDTO = this.modelMapper.map(book.getAuthor(),AuthorDTO.class);
     bookDTO.setAuthor(authorDTO);
     return bookDTO;
    }
}
