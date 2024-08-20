package com.keepcoding.app.alumnado.objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginInfo {
	
	
	//@NotNull(message="Password is incorrect or does not exist")
	//@NotBlank(message="Username is incorrect or does not exist")
	private String inputUserName;
	
	
	
	// @NotNull(message="Password is incorrect or does not exist")
	//@NotBlank(message="Password is requered")
	private String inputPassword;
	
	
	public void nullUser() {
		this.inputUserName = null;
	}
	
	public void nullPassword() {
		this.inputPassword = null;
	}
//	private boolean nonUser = false;
//	private boolean nonPassword = false;
//	
//	
//	public void changeUser(boolean change) {
//		this.nonUser = change;
//	}
//	
//	public void changePassword(boolean change) {
//		this.nonPassword = change;
//	}
//	
//	public boolean isNonUser() {
//		return nonUser;
//	}
//	public void setNonUser(boolean nonUser) {
//		this.nonUser = nonUser;
//	}
//	public Boolean getNonPassword() {
//		return nonPassword;
//	}
//	public void setNonPassword(boolean nonPassword) {
//		this.nonPassword = nonPassword;
//	}
	
	public String getInputUserName() {
		return inputUserName;
	}
	public void setInputUserName(String inputUserName) {
		this.inputUserName = inputUserName;
	}
	public String getInputPassword() {
		return inputPassword;
	}
	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}

	

}
