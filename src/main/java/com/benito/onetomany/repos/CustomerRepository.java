package com.benito.onetomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.benito.onetomany.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
