package com.example.lab.service;

import com.example.lab.model.Author;
import com.example.lab.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> listAll();

    Optional<Author> findById(Long id);

    Author create(String name, String surname, Country country);

}
