package com.example.books_rest_api_project.init;

import com.example.books_rest_api_project.model.entity.AuthorEntity;
import com.example.books_rest_api_project.model.entity.BookEntity;
import com.example.books_rest_api_project.repository.AuthorRepository;
import com.example.books_rest_api_project.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DBInit implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public DBInit(BookRepository bookRepository,
                  AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (bookRepository.count() == 0) {
            AuthorEntity joshua = new AuthorEntity().setName("Joshua Bloch");
            AuthorEntity craig = new AuthorEntity().setName("Craig Walls");
            AuthorEntity marko = new AuthorEntity().setName("Marko Luksa");

            joshua = authorRepository.save(joshua);
            craig = authorRepository.save(craig);
            marko = authorRepository.save(marko);

            BookEntity effectiveJava = new BookEntity().
                    setTitle("Effective Java").
                    setIsbn("978-0134685991").
                    setAuthor(joshua);

            BookEntity javaPuzzlers = new BookEntity().
                    setTitle("Java™ Puzzlers: Traps, Pitfalls, and Corner Cases").
                    setIsbn("978-0321336781").
                    setAuthor(joshua);

            BookEntity springInAction = new BookEntity().
                    setTitle("Spring in Action, Fifth Edition").
                    setIsbn("978-1617294945").
                    setAuthor(craig);

            BookEntity k8sInAction = new BookEntity().
                    setTitle("Kubernetes in Action").
                    setIsbn("978-1617293726").
                    setAuthor(marko);

            joshua.setBooks(List.of(effectiveJava, javaPuzzlers));
            craig.setBooks(List.of(springInAction));
            marko.setBooks(List.of(k8sInAction));

            bookRepository.saveAll(List.of(effectiveJava, javaPuzzlers, springInAction, k8sInAction));
        }
    }
}
