package app.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Branch;
import app.entity.Location;
import app.entity.Product;
import app.repositories.BranchRepo;
import app.repositories.LocationRepo;
import app.repositories.ProductRepo;

@Component
public class AppInitializer {
	
	@Autowired
	private LocationRepo lr;
	
	@Autowired
	private ProductRepo pr;
	
	@Autowired
	private BranchRepo br;
	
	@Autowired
	private ProductComponent pc;
	
	@Autowired
	private LocationComponent lc;
	
	
	

	private String names[] = {"Faber Hall", "Berchmans Hall", "Xavier Hall", "New Rizal Library", "Faura Hall",
								"Bellarmine Field", "Cervini Hall", "Eliazo Hall", "Ocampo Field", "Moro Lorenzo Field"};
	private double lat[] = {14.640486382388463, 14.639640371697375, 14.640008879822846, 14.639988060032673, 14.639527472724218,
							14.640697008956545, 14.639321716302177, 14.638636924381496, 14.636648429641141, 14.637101112836469};
	private double lon[] = {121.07792948980521, 121.07843910953036, 121.07851957580276, 121.07597247045652, 121.07691842002717,
							121.07917808620927, 121.08035438966124, 121.08040506090641, 121.07673185462247, 121.07552057158996};
	private String sizes[] = {"A4", "Long", "Short"};
	private String types[] = {"Black", "Colored"};
	private Double prod_prices[] = {2.0D, 5.0D, 2.0D, 5.5D, 2.0D, 6.0D};
	

	
	

	private void initialize() {
		for(int i=0; i<10; i++) {
			Location l = new Location();
			l.setLocation_name(names[i]);
			l.setLatitude(new Double(lat[i]));
			l.setLongnitude(new Double(lon[i]));
			
			l=lr.save(l);
		}	
		
		int z = 0;
		for(String size : sizes) {
			for(String type : types) {
				pc.createProduct(prod_prices[z], type, size);
				z++;
			}
		}
		
		lc.createBranch( "Cervini Branch", 7L, "09123456789");
		lc.createBranch( "Elizao Branch", 8L, "09987654321");
		 
		
		
	}

	
	@PostConstruct
	public void init() {
		if(pr.count()==0) {
			initialize();
		}
	}
}
