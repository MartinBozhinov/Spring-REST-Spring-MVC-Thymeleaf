package com.example.books_rest_api_project.model.dto;

public class AuthorDTO extends BaseDTO{

    private String name;

    public AuthorDTO() {
    }

    public String getName() {
        return name;
    }

    public AuthorDTO setName(String name) {
        this.name = name;
        return this;
    }
}
