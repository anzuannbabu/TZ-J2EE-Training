package com.pivotalsoft.demo.service;

import com.pivotalsoft.demo.model.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}
