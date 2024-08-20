package com.keepcoding.app.alumnado.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keepcoding.app.alumnado.entity.Student;
import com.keepcoding.app.alumnado.service.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentRepo;
	
	@GetMapping("/home")
	public String alumnosList(Model modelo) {
		modelo.addAttribute("studentsList", studentRepo.allStudents());
		return "students";
	}
	
	@GetMapping("/new")
	public String createStudent(Model modelo) {
		modelo.addAttribute("newStudent", new Student());
		return "createStudent";
	}
	
	@PostMapping("/save/new")
	public String saveStudent(@Valid @ModelAttribute("newStudent") Student student, Errors error) {
		
		Optional<Student> byEmail = studentRepo.getByEmail(student.getEmail());
		if(byEmail.isPresent()) {
			error.rejectValue("email","error.email","This email is already in use");
			return "createStudent";
			
		}
		
		Optional<Student> byDni = studentRepo.getByDni(student.getDni());
		if(byDni.isPresent()) {
			error.rejectValue("dni","error.dni","This DNI is already in use");
			return "createStudent";
		}
		
		if (error.hasErrors()) {
			return "createStudent";
		}	
		
		studentRepo.saveStudent(student);
		return "redirect:/student/home";	
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentRepo.deleteById(id);
		return "redirect:/student/home";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editStudentById(Model modelo, @PathVariable long id) {
		modelo.addAttribute("editedStudent", studentRepo.getById(id));
		return "edit_student";
	}
	
	
	@PostMapping("/save/edit/{id}")
	public String saveEditedStudent(@Valid @PathVariable long id, @ModelAttribute("editedStudent") Student student, Errors error) {
		
		Student byId = studentRepo.getById(id);
		
		Optional<Student> byEmail = studentRepo.getByEmail(student.getEmail());
		if(!byId.getEmail().equals(student.getEmail())) {
			if(byEmail.isPresent()) {
				error.rejectValue("email","error.email","This email is already in use");
				return "edit_student";
			}
		}
		
		if(!byId.getDni().equals(student.getDni())) {
			Optional<Student> byDni = studentRepo.getByDni(student.getDni());
			if(byDni.isPresent()) {
				error.rejectValue("dni","error.dni","This DNI is already in use");
				return "edit_student";
			}	
		}
		
		if(student.getName() == "") {
			error.rejectValue("name","error.name","Name is requered");
			return "edit_student";
		}
		
		if(student.getLastname() == "") {
			error.rejectValue("lastname","error.lastname","lastname is requered");
			return "edit_student";
		}
		
		if(student.getPhone() == 0) {
			error.rejectValue("phone","error.phone","Phone is requered");
			return "edit_student";
		}
		
		if(student.getBirthdate() == null) {
			error.rejectValue("birthdate","error.birthdate","Birthdate is requered");
			return "edit_student";
		}
		
		if(student.getEmail() == "") {
			error.rejectValue("email","error.email","Email is requered");
			return "edit_student";
		}
		
		if(student.getDni() == "") {
			error.rejectValue("dni","error.dni","DNI is requered");
			return "edit_student";
		}

	
		studentRepo.saveStudent(student);
		return "redirect:/student/home";
	}
	
	@GetMapping("/filter")
	public String filterByName(@RequestParam("searchByName") String name, Model modelo, Model appear) {
		
		List<Student> listByName = studentRepo.listByName(name);
		if(listByName.size() == 0) {
			appear.addAttribute("appear", true);
		}
		
		modelo.addAttribute("listByName", studentRepo.listByName(name));
		return "filter_name";
		
		
	}
	
	
	
	
	
	
	
	
	
}
