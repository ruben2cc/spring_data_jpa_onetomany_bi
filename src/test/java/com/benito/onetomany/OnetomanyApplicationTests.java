package com.benito.onetomany;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.benito.onetomany.entities.Customer;
import com.benito.onetomany.entities.PhoneNumber;
import com.benito.onetomany.repos.CustomerRepository;

@SpringBootTest
class OnetomanyApplicationTests {

	@Autowired
	CustomerRepository repos;
	
	@Test
	void oneToManyTest() {
		Customer customer = new Customer("Ruben");
		PhoneNumber ph1 = new PhoneNumber("123456789", "home");
		PhoneNumber ph2 = new PhoneNumber("987654321", "celular");
		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);
		repos.save(customer);
	}
	
	@Test
	@Transactional
	public void testLoadCustomer() {
		Customer customer = repos.findById(4).get();
		System.out.println(customer);
		System.out.println(customer.getNumbers());
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer = repos.findById(5).get();
		customer.setName("Ruben Benito");
		List<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(n -> n.setType("cell"));
		repos.save(customer);
	}

	@Test
	public void testDeleteCustomer() {
		repos.deleteById(5);	
	
	}
}
