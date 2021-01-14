package com.POJO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="employeedetails")
public class EmployeeDetails {

	@Id
	@Column(name="email_id")
	private String email_id;
	
	@Column(name="user_type")
	private String user_type;
	
	@Column(name="department")
	private String department;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="reporting")
	private String reporting;
	
	@Column(name="phone_number")
	private long phone_number;
	
	@JsonManagedReference
	@OneToMany(mappedBy="reference_email_id",fetch=FetchType.LAZY,
			cascade= CascadeType.ALL,orphanRemoval = true)
	
	private List<Leaves> leaves;

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getReporting() {
		return reporting;
	}

	public void setReporting(String reporting) {
		this.reporting = reporting;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public List<Leaves> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<Leaves> leaves) {
		this.leaves = leaves;
	}

	public EmployeeDetails(String email_id, String user_type, String department, String designation, String reporting,
			long phone_number, List<Leaves> leaves) {
	
		this.email_id = email_id;
		this.user_type = user_type;
		this.department = department;
		this.designation = designation;
		this.reporting = reporting;
		this.phone_number = phone_number;
		this.leaves = leaves;
	}

	public EmployeeDetails() {
		
	}

	@Override
	public String toString() {
		return "EmployeeDetails [email_id=" + email_id + ", user_type=" + user_type + ", department=" + department
				+ ", designation=" + designation + ", reporting=" + reporting + ", phone_number=" + phone_number + "]";
	} 
	
	public void add(Leaves leave)
	{
		if(leaves==null)
		{
			leaves=new ArrayList<Leaves>();
		}
		leaves.add(leave);
		leave.setReference_email_id(this);
	}
	
	
}
