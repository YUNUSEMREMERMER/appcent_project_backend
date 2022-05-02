package com.example.todoApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoApp.business.abstracts.UserService;
import com.example.todoApp.core.dataAccess.UserDao;
import com.example.todoApp.core.entities.User;
import com.example.todoApp.core.utilities.results.DataResult;
import com.example.todoApp.core.utilities.results.ErrorDataResult;
import com.example.todoApp.core.utilities.results.Result;
import com.example.todoApp.core.utilities.results.SuccessDataResult;
import com.example.todoApp.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		if(this.userDao.findByEmail(email) != null) {
			return new SuccessDataResult<User>(this.userDao.findByEmail(email),"kullanıcı bulundu");
		}
		else {
			return new ErrorDataResult("kullanıcı bulunamadı");
		}
		
	}

	@Override
	public DataResult<User> add(User user) {
		// TODO Auto-generated method stub
		this.userDao.save(user);
		return new SuccessDataResult(user,"kullanıcı eklendi");
	}

	@Override
	public Result remove(String id) {
		this.userDao.deleteById(id);
		return new SuccessResult("kullanıcı silindi");
	}

	

}
