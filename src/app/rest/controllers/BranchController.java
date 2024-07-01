package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import app.components.LocationComponent;
import app.components.ProductComponent;
import app.entity.Branch;
import app.entity.OrderStatement;
import app.entity.Product;




@Path("/branch")
public class BranchController {
	
	@Autowired
	private LocationComponent lc;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Branch> getAllBranches() {
		return lc.getStores();
	}
	
	
	@GET
	@Path("/orders")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderStatement> getBranchOrders(@QueryParam("branch_id") Long branch_id) {
		return lc.getBranchOrders(branch_id);
	}
	
}
