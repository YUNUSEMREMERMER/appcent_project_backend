package com.example.todoApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoApp.business.abstracts.TodoService;
import com.example.todoApp.core.utilities.results.DataResult;
import com.example.todoApp.core.utilities.results.SuccessDataResult;
import com.example.todoApp.dataAccess.abstracts.TodoDao;
import com.example.todoApp.entities.concretes.Todo;

@Service
public class TodoManager implements TodoService {

	private TodoDao todoDao;
	
	@Autowired
	public TodoManager(TodoDao todoDao) {
		super();
		this.todoDao = todoDao;
	}

	@Override
	public DataResult<List<Todo>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Todo>>(this.todoDao.findAll(),"todos listelendi");
	}

	@Override
	public DataResult<Todo> add(Todo todo) {
		// TODO Auto-generated method stub
		this.todoDao.save(todo);
		return new SuccessDataResult<Todo>(todo,"todo eklendi");
	}

	

}
