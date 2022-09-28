package com.library.app.service;

import com.library.app.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User u);

    User findUserByEmail(String email);

    User findUserByPhoneNumber(String phoneNumber);

    void deleteUserByID(Long id);

    User findUserByID(Long id);

    User updateUser(User u);

    List<User> findAllUser();
}
