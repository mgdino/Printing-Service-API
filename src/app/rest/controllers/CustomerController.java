package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import app.components.CustomerComponent;
import app.components.ProductComponent;
import app.entity.Customer;
import app.entity.Product;




@Path("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerComponent cc;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAllCustomer() {
		return cc.getCustomers();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String saveStrayAnimal(@FormParam("first_name")String first_name,@FormParam("last_name") String last_name,
								@FormParam("contact_number") String contact_number) {
		cc.createCustomer(first_name, last_name, contact_number);
		return "Success!";
	}

}
