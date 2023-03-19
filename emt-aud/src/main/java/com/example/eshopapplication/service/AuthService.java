package com.example.eshopapplication.service;

import com.example.eshopapplication.model.User;

public interface AuthService {

    User login(String username, String password);
}
