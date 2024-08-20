package com.keepcoding.app.alumnado.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message="Name is requered")
	private String name;
	
	@Column(unique = true)
	@Email(message="Email is Invalid")
	@NotBlank(message="Email is requered")
	private String email;
	
	@Column(unique = true)
	@NotBlank(message="Username is requered")
	private String username;
	
	@NotBlank(message="Password is requered")
	private String password;
	
	private String activo;
	
	
	
	public void onlineState() {
		this.activo = "online";
	}
	
	public void offlineState() {
		this.activo = "offline";
	}
	
	public void nullUsername() {
		this.username = null;
	}
	
	public void nullEmail() {
		this.email = null;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	private static final long serialVersionUID = 1L;

}
