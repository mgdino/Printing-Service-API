package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.OrderStatement;
import app.entity.OrderItem;
import app.repositories.OrderStatementRepo;
import app.repositories.OrderItemRepo;

@Component
public class OrderComponent {
	
	@Autowired
	private OrderStatementRepo osrep;
	
	
	public List<OrderStatement> getAllOrders() {
		return osrep.findAll();
	}
	public OrderStatement getStatus(Long order_id) {
		return osrep.findByOrderId(order_id);
	}

	public Long placeOrder(Long customer_id, Long branch_id, Long location_id, Boolean to_be_delivered) {
		OrderStatement os = new OrderStatement();
		os.setCustomer_id(customer_id);;
		os.setBranch_id(branch_id);
		os.setLocation_id(location_id);
		os.setTo_be_delivered(to_be_delivered);
		if(to_be_delivered) {
			os.setTotal_amount(25D);
		} else {
			os.setTotal_amount(0D);
		}
		os = osrep.save(os);
		Long id = os.getOrder_id();
		return id;
	}

	
}
