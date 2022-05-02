package com.example.todoApp.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoApp.core.entities.User;

public interface UserDao extends JpaRepository<User,String>{
	User findByEmail(String email);
}
