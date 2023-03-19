package com.example.lab.service;

import com.example.lab.model.Author;
import com.example.lab.model.Book;
import com.example.lab.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listAll();

    Optional<Book> findById(Long id);

    Book create(String name, Category category, Long authorId, Integer availableCopies);

    Book update(Long id, String name, Category category, Long authorId, Integer availableCopies);

    Book delete(Long id);
    Book rent(Long id);
}
