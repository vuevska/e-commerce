package com.example.eshopapplication.service;

import com.example.eshopapplication.model.enumerations.Role;
import com.example.eshopapplication.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
}
