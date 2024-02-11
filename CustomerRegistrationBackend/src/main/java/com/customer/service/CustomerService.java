package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.module.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	public Customer addCustomerData(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer updateCustomerData(Long id, Customer updatecustomer) {
		 Customer customerExit = customerRepository.findById(id).orElse(null);
		 if(customerExit != null) {
			 customerExit.setName(updatecustomer.getName());
			 customerExit.setAge(updatecustomer.getAge());
			 customerExit.setEmail(updatecustomer.getEmail());
			 return customerRepository.save(customerExit);
		 }
		 else {
			 return null;
		 }
	}
	
	public void deleteCustomerData(Long id) {
		customerRepository.deleteById(id);
	}
}
