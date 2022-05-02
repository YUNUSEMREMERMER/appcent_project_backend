package com.example.todoApp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoApp.business.abstracts.TodoService;
import com.example.todoApp.core.utilities.results.DataResult;
import com.example.todoApp.entities.concretes.Todo;


@RestController
@RequestMapping("/api/todos")
@CrossOrigin
public class TodosContoller {
	
	private TodoService todoService;

	@Autowired
	public TodosContoller(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Todo>> getAll(){
		return this.todoService.getAll();
	}
	
	@PostMapping("/add")
    public DataResult<Todo> addUser(@RequestBody Todo todo){
        return this.todoService.add(todo);
    }
	
}
