package com.keepcoding.app.alumnado.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.app.alumnado.entity.User;
import com.keepcoding.app.alumnado.repository.UserRepository;
import com.keepcoding.app.alumnado.service.UserService;

@Service
public class UserServiceRepository implements UserService{
	
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> allUsers() {
		List<User> allUsers = userRepo.findAll();
		return allUsers;
	}


	@Override
	public User getById(long id) {
		Optional<User> byId = userRepo.findById(id);
		return byId.get();
	}

	@Override
	public Optional<User> getByUserName(String userName) {
		Optional<User> byUserName = userRepo.findByUsername(userName);
		return byUserName;
	}


	@Override
	public User userSave(User user) {
		return userRepo.save(user);
	}


	@Override
	public Optional<User> getByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	
	

	
	
	
	
	
	
	


}
