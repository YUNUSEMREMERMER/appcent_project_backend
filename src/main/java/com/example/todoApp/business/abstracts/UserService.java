package com.example.todoApp.business.abstracts;

import java.util.List;

import com.example.todoApp.core.entities.User;
import com.example.todoApp.core.utilities.results.DataResult;
import com.example.todoApp.core.utilities.results.Result;



public interface UserService {
	DataResult<List<User>> getAll();
	DataResult<User> findByEmail(String email);
	DataResult<User>  add(User user);
	Result remove(String id);
}
