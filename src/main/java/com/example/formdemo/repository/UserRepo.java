package com.example.formdemo.repository;

import com.example.formdemo.domain.User;

public interface UserRepo {

    Iterable<User> findAll();

    User findByUsername(String username);

    User save(User user);
}
