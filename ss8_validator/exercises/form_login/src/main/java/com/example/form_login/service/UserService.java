package com.example.form_login.service;

import com.example.form_login.model.User;
import com.example.form_login.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
