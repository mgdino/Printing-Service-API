package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Customer;
import app.repositories.CustomerRepo;

@Component
public class CustomerComponent {
	
	@Autowired
	private CustomerRepo cus_rep;
	
	public List<Customer> getCustomers(){
		return cus_rep.findAll();
	}
	
	public void createCustomer(String first_name, String last_name, String contact_number) {
		Customer c = new Customer();
		c.setFirst_name(first_name);
		c.setLast_name(last_name);
		c.setContact_number(contact_number);
		c = cus_rep.save(c);
	}
	
	

}
