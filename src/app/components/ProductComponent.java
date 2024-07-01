package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Product;
import app.repositories.ProductRepo;

@Component
public class ProductComponent {
	
	@Autowired
	private ProductRepo prod_rep;
	
	public List<Product> getProducts(){
		return prod_rep.findAll();
	}
	
	public void createProduct(Double price, String type, String size) {
		Product p = new Product();
		p.setName(type + " " + size);
		p.setPrice(price);
		p.setType(type);
		p.setSize(size);
		p = prod_rep.save(p);
	}
}
