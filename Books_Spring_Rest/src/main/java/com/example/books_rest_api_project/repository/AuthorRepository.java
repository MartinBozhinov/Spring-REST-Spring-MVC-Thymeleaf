package com.example.books_rest_api_project.repository;

import com.example.books_rest_api_project.model.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {

   Optional<AuthorEntity> findByName(String name);
}
