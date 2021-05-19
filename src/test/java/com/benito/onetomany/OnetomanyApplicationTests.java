package com.benito.onetomany;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		ArrayList<PhoneNumber> numbers = new ArrayList<>();
		PhoneNumber ph1 = new PhoneNumber("123456789", "home");
		ph1.setCustomer(customer);
		numbers.add(ph1);
		PhoneNumber ph2 = new PhoneNumber("987654321", "celular");
		ph2.setCustomer(customer);
		numbers.add(ph2);
		customer.setNumbers(numbers);
		
		repos.save(customer);
	}

}
