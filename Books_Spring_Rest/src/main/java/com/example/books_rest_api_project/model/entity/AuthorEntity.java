package com.example.books_rest_api_project.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "authors")
public class AuthorEntity extends BaseEntity{

       private String name;
       private List<BookEntity> books;

    public AuthorEntity() {
    }





    public String getName() {
        return name;
    }

    public AuthorEntity setName(String name) {
        this.name = name;
        return this;
    }
    @OneToMany(mappedBy = "author")

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

    public AuthorEntity addBook(BookEntity book){
        this.books.add(book);
        return this;
    }
}
