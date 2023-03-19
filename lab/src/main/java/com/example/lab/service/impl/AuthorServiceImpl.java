package com.example.lab.service.impl;

import com.example.lab.model.Author;
import com.example.lab.model.Country;
import com.example.lab.model.exceptions.AuthorNotFoundException;
import com.example.lab.repository.AuthorRepository;
import com.example.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.of(this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id)));
    }

    @Override
    public Author create(String name, String surname, Country country) {
        Author author = new Author(name, surname, country);
        this.authorRepository.save(author);
        return author;
    }
}
