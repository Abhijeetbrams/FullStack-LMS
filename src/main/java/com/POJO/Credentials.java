package com.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credentials")
public class Credentials {

	@Id
	@Column(name="emailId")
	private String email_id;
	
	@Column(name="displayName")
	private String display_name;
	
	@Column(name="password")
	private String password;

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Credentials(String display_name, String email_id, String password) {
		
		this.display_name = display_name;
		this.email_id = email_id;
		this.password = password;
	}

	public Credentials() {
		
	}

	@Override
	public String toString() {
		return "Credentials [display_name=" + display_name + ", email_id=" + email_id + ", password=" + password + "]";
	}
	
	
	
	
	
}
