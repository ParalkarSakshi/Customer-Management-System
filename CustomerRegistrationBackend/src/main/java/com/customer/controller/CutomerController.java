package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.customer.module.Customer;
import com.customer.service.CustomerService;

//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("customers")
public class CutomerController {

//	@Autowired
//	 private JavaMailSender javaMailSender; 
	
	@Autowired
	private CustomerService customerService;

	
	@GetMapping
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	 
	 
//	 @PostMapping("/send")
//		public String sendEmail(@RequestBody Customer emailRequest) {
//			SimpleMailMessage message = new SimpleMailMessage();
//			message.setFrom("sakshiparalkar1@gmail.com");
//			message.setTo(emailRequest.getTo());
//			message.setSubject(emailRequest.getSubject());
//			message.setText(emailRequest.getBody());
//			javaMailSender.send(message);
//			return "Email sent successfully";
//		}
	
	
	@PostMapping
	public Customer addCustomerData(@RequestBody Customer customer) {
		return customerService.addCustomerData(customer);
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomerData(@PathVariable Long id, @RequestBody Customer updatecustomer) {
		return customerService.updateCustomerData(id, updatecustomer);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomerData(@PathVariable Long id) {
		customerService.deleteCustomerData(id);
	}
	
}
