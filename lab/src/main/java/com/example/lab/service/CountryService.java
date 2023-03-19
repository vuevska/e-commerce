package com.example.lab.service;

import com.example.lab.model.Country;

import java.util.Optional;

public interface CountryService {

    Country create(String name, String continent);

    Country findById(Long id);
}
