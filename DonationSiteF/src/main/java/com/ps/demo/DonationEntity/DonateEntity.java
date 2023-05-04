package com.ps.demo.DonationEntity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Donation_System")
public class DonateEntity {
	@Id
	/* @GeneratedValue(strategy=GenerationType.IDENTITY) */
	private int id;
	 private String phone;
	 private int salary;
	
	
	
	
	

	

	public DonateEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DonateEntity [id=" + id + ", phone=" + phone + ", salary=" + salary + "]";
	}
	

}