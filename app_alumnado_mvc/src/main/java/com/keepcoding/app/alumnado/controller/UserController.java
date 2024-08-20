package com.keepcoding.app.alumnado.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.keepcoding.app.alumnado.entity.User;
import com.keepcoding.app.alumnado.objects.LoginInfo;
import com.keepcoding.app.alumnado.service.UserService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/user")
@SessionAttributes("login_user")
public class UserController {
	
	@Autowired
	private UserService userRepo;
	
	@GetMapping("/validate")
	public String validateUser(@Valid @ModelAttribute("loginInfo") LoginInfo login, Errors error, Model modelo) {

		Optional<User> byUserName = userRepo.getByUserName(login.getInputUserName());
		if (byUserName.isPresent()) {
			User user = byUserName.get();
			if (user.getPassword().equals(login.getInputPassword())) {
				user.onlineState();
				modelo.addAttribute("login_user", user);
				return "redirect:/student/home";

			} else {
				login.nullPassword();
				ValidationUtils.rejectIfEmpty(error, "inputPassword", "error.inputPassword",
						"password is incorrect");
				if (error.hasErrors()) {
					return "loginUser";
				}
			}
		}

		login.nullUser();
		ValidationUtils.rejectIfEmpty(error, "inputUserName", "error.inputUserName",
				"Username is incorrect or does not exist");
		if (error.hasErrors()) {
			return "loginUser";
		}

		return "loginUser";
	}
	
	
	
	
	
	@GetMapping("/create")
	public String createUser(Model modelo) {
		modelo.addAttribute("newUser", new User());
		return "createUser";
	}
	
	@PostMapping("/save")
	public String userSave(@Valid @ModelAttribute("newUser") User user, Errors error) {
		
		Optional<User> byUserName = userRepo.getByUserName(user.getUsername());
		if (byUserName.isPresent()) {
			error.rejectValue("username", "error.username", "This username is already in use");
			return "createUser";
			
		}
		
		Optional<User> byEmail = userRepo.getByEmail(user.getEmail());
		if(byEmail.isPresent()) {
			error.rejectValue("email", "error.email", "This email is already in use");
			return "createUser";
			
		}
		
		
		
		if (error.hasErrors()) {
			return "createUser";
		}
		
		userRepo.userSave(user);
		return "redirect:/";
		
	}
	
	
	@GetMapping("/edit")
	public String editUserForm() {
		return "edit_user";
	}
	

	
	@PostMapping("/save/edit")
	public String editUserForm(@Valid @ModelAttribute("login_user") User edited_user, Errors error) {
		
		User byId = userRepo.getById(edited_user.getId());
		
		Optional<User> byUserName = userRepo.getByUserName(edited_user.getUsername());
		if(!byId.getUsername().equals(edited_user.getUsername())) {
			if (byUserName.isPresent()) {
				error.rejectValue("username", "error.username", "This username is already in use");
				return "edit_user";
				
			}	
		}
		
		
		Optional<User> byEmail = userRepo.getByEmail(edited_user.getEmail());
		if(!byId.getEmail().equals(edited_user.getEmail())) {
			if(byEmail.isPresent()) {
				error.rejectValue("email", "error.email", "This email is already in use");
				return "edit_user";	
			}	
		}

		

		if (error.hasErrors()) {
			return "edit_user";
		}
		
		userRepo.userSave(edited_user);
		return "redirect:/student/home";
		
	}
	
	
	@GetMapping("/info")
	public String infoUser() {
		return "user_info";
	}
	
	@GetMapping("/close/account")
	public String closeAccount(@ModelAttribute("login_user") User closed) {
		closed.offlineState();
		return "redirect:/";
	}

	
	
	

}
