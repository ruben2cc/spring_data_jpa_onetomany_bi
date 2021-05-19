package com.benito.onetomany.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<PhoneNumber> numbers;

	public List<PhoneNumber> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<PhoneNumber> numbers) {
		this.numbers = numbers;
	}

	public Customer() {
	}
	
	public Customer(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
