package com.keepcoding.app.alumnado.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.app.alumnado.entity.Student;
import com.keepcoding.app.alumnado.repository.StudentRepository;
import com.keepcoding.app.alumnado.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> allStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void deleteById(Long id) {
		studentRepo.deleteById(id);
		
	}

	@Override
	public Student getById(long id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public Optional<Student> getByDni(String dni) {
		return studentRepo.findByDni(dni);
	}

	@Override
	public Optional<Student> getByEmail(String email) {
		return studentRepo.findByEmail(email);
	}

	@Override
	public List<Student> listByName(String name) {
		return studentRepo.findByName(name);
	}





	

	
	
	

}
