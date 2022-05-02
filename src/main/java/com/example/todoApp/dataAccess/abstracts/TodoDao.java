package com.example.todoApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoApp.entities.concretes.Todo;

public interface TodoDao extends JpaRepository<Todo,Integer>{

}
