package com.example.todoApp.business.abstracts;

import java.util.List;

import com.example.todoApp.core.utilities.results.DataResult;
import com.example.todoApp.entities.concretes.Todo;



public interface TodoService {
	DataResult<List<Todo>> getAll();
	DataResult<Todo> add(Todo todo);
}
