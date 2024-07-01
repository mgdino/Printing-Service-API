package app.rest.controllers;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import app.components.LocationComponent;
import app.components.OrderComponent;
import app.components.OrderItemComponent;
import app.entity.OrderStatement;
import app.entity.Product;




@Path("/order")
public class OrderController {
	
	@Autowired
	private OrderComponent oc;
	
	@Autowired
	private OrderItemComponent oic;
	
	@Autowired
	private LocationComponent lc;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderStatement> getAllOrders() {
		return oc.getAllOrders();
	}
	

	@GET
	@Path("/status")
	@Produces(MediaType.APPLICATION_JSON)
	public OrderStatement getOrderStatus(@QueryParam("order_id") Long order_id) {
		return oc.getStatus(order_id);
	}
	
	@GET
	@Path("/bylocation")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderStatement> getOrdersByLocation(@QueryParam("location_name") String location_name) {
		return lc.getOrdersByLocation(location_name);
	}
	
	@GET
	@Path("/image")
	@Produces("image/jpeg")
	public byte[] getOrderItemImage(@QueryParam("order_item_id") Long order_item_id) throws Exception {
		return oic.getImageFile(order_item_id);
	}
	
	@POST
	@Path("/add")
	public Long placeOrder(@FormParam("customer_id") Long customer_id, @FormParam("branch_id") Long branch_id, @FormParam("to_be_delivered") Boolean to_be_delivered, @FormParam("location_id") Long location_id ) {
		return oc.placeOrder(customer_id, branch_id, location_id, to_be_delivered);
	}
	
	
	@POST
	@Path("/add-items")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String upload(@FormDataParam("file") InputStream uploadedInputStream,
            			 @FormDataParam("file") FormDataContentDisposition fileDetails, 
            			 @FormDataParam("order_id") Long order_id,
            			 @FormDataParam("product_id") Long product_id,
            			 @FormDataParam("quantity") Long quantity) {
		return oic.saveOrderItem(uploadedInputStream, fileDetails.getFileName(),order_id,product_id,quantity);
	}

}
