package com.nt.start.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee {

	//if we dont give @Table annotation, the default table name is class name.
	@Id // to provide a primary key of our Entity
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	//To provide primary key generation strategy.
	
	private long id;
	
	@Column(name = "first_name")//To map column name to the Field
	private String firstName;
	
	//if we dont give @Column annotation, the default column name is the Field name
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
