package com.POJO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="leaves")
public class Leaves {
	
     @Id
     @Column(name="id")
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;
	
	@Column(name="earned_leaves")
	private int earned_leaves;
	
	@Column(name="casual_leave")
	private int casual_leave;
	
	@Column(name="sick_leave")
	private int sick_leave;
	
	@Column(name="marriage_leave")
	private int marriage_leave;
	
	@Column(name="paternity_leave")
	private int paternity_leave;
	
	@Column(name="bereavement_leave")
	private int bereavement_leave;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.EAGER,
			 cascade=CascadeType.ALL)
	@JoinColumn(name="reference_email_id")
	private EmployeeDetails  reference_email_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEarned_leaves() {
		return earned_leaves;
	}

	public void setEarned_leaves(int earned_leaves) {
		this.earned_leaves = earned_leaves;
	}

	public int getCasual_leave() {
		return casual_leave;
	}

	public void setCasual_leave(int casual_leave) {
		this.casual_leave = casual_leave;
	}

	public int getSick_leave() {
		return sick_leave;
	}

	public void setSick_leave(int sick_leave) {
		this.sick_leave = sick_leave;
	}

	public int getMarriage_leave() {
		return marriage_leave;
	}

	public void setMarriage_leave(int marriage_leave) {
		this.marriage_leave = marriage_leave;
	}

	public int getPaternity_leave() {
		return paternity_leave;
	}

	public void setPaternity_leave(int paternity_leave) {
		this.paternity_leave = paternity_leave;
	}

	public int getBereavement_leave() {
		return bereavement_leave;
	}

	public void setBereavement_leave(int bereavement_leave) {
		this.bereavement_leave = bereavement_leave;
	}


	public Leaves(int earned_leaves, int casual_leave, int sick_leave, int marriage_leave, int paternity_leave,
			int bereavement_leave, EmployeeDetails reference_email_id) {
		super();
		this.earned_leaves = earned_leaves;
		this.casual_leave = casual_leave;
		this.sick_leave = sick_leave;
		this.marriage_leave = marriage_leave;
		this.paternity_leave = paternity_leave;
		this.bereavement_leave = bereavement_leave;
		this.reference_email_id = reference_email_id;
	}

	public EmployeeDetails getReference_email_id() {
		return reference_email_id;
	}

	public void setReference_email_id(EmployeeDetails reference_email_id) {
		this.reference_email_id = reference_email_id;
	}

	public Leaves() {
		
	}

	@Override
	public String toString() {
		return "Leaves [id=" + id + ", earned_leaves=" + earned_leaves + ", casual_leave=" + casual_leave
				+ ", sick_leave=" + sick_leave + ", marriage_leave=" + marriage_leave + ", paternity_leave="
				+ paternity_leave + ", bereavement_leave=" + bereavement_leave + ", reference_email_id="
				+ reference_email_id + "]";
	}
	
	
	
}
