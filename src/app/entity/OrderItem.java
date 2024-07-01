package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long order_item_id;
	
	@Column
	@NotNull
	private Long order_id;
	
	@Column
	@NotNull
	private Long product_id;

	@Column
    private String filename;
	
	@Column
	@NotNull
	private Long quantity;

	public Long getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(Long order_item_id) {
		this.order_item_id = order_item_id;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	
	

}
