package com.keepcoding.app.alumnado.service;

import java.util.List;
import java.util.Optional;



import com.keepcoding.app.alumnado.entity.User;


public interface UserService {
	
	public List<User> allUsers();
	
	public User getById(long id);
	
	public Optional<User> getByUserName(String userName);
	
	public User userSave(User user);
	
	public Optional<User> getByEmail(String email);

}
