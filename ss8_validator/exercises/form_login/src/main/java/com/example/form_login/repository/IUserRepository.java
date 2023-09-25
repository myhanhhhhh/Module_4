package com.example.form_login.repository;

import com.example.form_login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
