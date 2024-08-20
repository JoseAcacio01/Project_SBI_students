package com.keepcoding.app.alumnado.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;


@Entity
@Table(name="students")
public class Student implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message="Name is requered")
	private String name;
	
	@NotBlank(message="Lastname is requered")
	private String lastname;
	
	@Digits(integer=10, fraction=0, message="Invalid number")
	@Min(value=100000, message="Invalid number")
	private int phone;
	
	
	@Column(unique = true)
	@Email(message="Email is Invalid")
	@NotBlank(message="Email is requered")
    private String email;
	
	
	@Column(unique = true)
	@NotBlank(message="DNI is requered")
	private String dni;
	
	@NotNull(message="Birthdate is requered")
	@Past(message="You cannot choose dates in the future")
	private LocalDate birthdate;
	
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}





	private static final long serialVersionUID = 1L;


}
