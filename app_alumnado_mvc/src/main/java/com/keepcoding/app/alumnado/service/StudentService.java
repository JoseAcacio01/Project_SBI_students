package com.keepcoding.app.alumnado.service;

import java.util.List;
import java.util.Optional;

import com.keepcoding.app.alumnado.entity.Student;

public interface StudentService {
	
	public List<Student> allStudents();
	
	public Student saveStudent(Student student);
	
	public void deleteById(Long id);
	
	public Student getById(long id);
	
	public Optional<Student> getByDni(String dni);
	
	public Optional<Student> getByEmail(String email);
	
	public List<Student> listByName(String name);

}
