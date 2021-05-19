package com.benito.onetomany;

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
		PhoneNumber ph1 = new PhoneNumber("123456789", "home");
		PhoneNumber ph2 = new PhoneNumber("987654321", "celular");
		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);
		repos.save(customer);
	}

}
