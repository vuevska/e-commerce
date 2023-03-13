package com.example.eshopapplication.service;

import com.example.eshopapplication.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    Optional<Manufacturer> findById(Long id);

    List<Manufacturer> findAll();

    Optional<Manufacturer> save(String name, String address);

    void deleteById(Long id);
}
