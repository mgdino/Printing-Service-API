package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Branch;
import app.entity.Location;
import app.entity.OrderStatement;
import app.repositories.BranchRepo;
import app.repositories.LocationRepo;
import app.repositories.OrderStatementRepo;

@Component
public class LocationComponent {
	
	@Autowired
	private BranchRepo branch_rep;
	
	@Autowired
	private LocationRepo loc_rep;
	
	@Autowired
	private OrderStatementRepo os_rep;
	
	public void createLocation(String location_name, Double latitude, Double longitude) {
		Location l = new Location();
		l.setLocation_name(location_name);
		l.setLatitude(latitude);
		l.setLongnitude(longitude);
		loc_rep.save(l);
	}
	
	public void createBranch(String branch_name, Long location_id, String contact_number) {
		Branch b = new Branch();
		b.setBranch_name(branch_name);
		b.setBranch_location_id(location_id);
		b.setContact_number(contact_number);
		branch_rep.save(b);
	}
	
	public List<Branch> getStores() {
		return branch_rep.findAll();
	}
	public List<OrderStatement> getBranchOrders(Long branch_id) {
		return os_rep.findByBranchId(branch_id);
	}
	public List<OrderStatement> getOrdersByLocation(String location_name) {
		Location loc = loc_rep.findByLocationName(location_name);
		return os_rep.findByLocationId(loc.getLocationId());
	}

}
