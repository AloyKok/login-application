package com.aloysiouskok.loginapplication.service;

import com.aloysiouskok.loginapplication.model.UserModel;
import com.aloysiouskok.loginapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
     private UserRepository userRepository;

    public Optional<UserModel> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean isValidUser(String username, String password) {
        Optional<UserModel> user = findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }



}
