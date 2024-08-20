package com.keepcoding.app.alumnado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keepcoding.app.alumnado.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Optional<Student> findByDni(String dni); 

	Optional<Student> findByEmail(String email);
	
	List<Student> findByName(String name);

}
