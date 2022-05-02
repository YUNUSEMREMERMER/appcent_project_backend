package com.example.todoApp.api.controllers;

import java.util.HashMap;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoApp.business.abstracts.UserService;
import com.example.todoApp.core.entities.User;
import com.example.todoApp.core.utilities.results.DataResult;
import com.example.todoApp.core.utilities.results.ErrorDataResult;
import com.example.todoApp.core.utilities.results.Result;



@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {
	
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getbyemail")
    public DataResult<User> getUser(@RequestParam String email){
        return this.userService.findByEmail(email);
    }
	
	@PostMapping("/add")
    public DataResult<User> addUser(@Valid @RequestBody User user){
    	
        return this.userService.add(user);
    }
	
	@PostMapping("/remove")
    public Result removeUser(@RequestParam String id){
    	
        return this.userService.remove(id);
    }

    /*
	@PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }
	*/
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors 
		= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
	
	
}
