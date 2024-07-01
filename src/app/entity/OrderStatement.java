package app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



import org.springframework.data.annotation.CreatedDate;

@Entity
public class OrderStatement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long order_id;
	
	@Column
	@NotNull
	private Long customer_id;
	
	@CreatedDate
    @Column(nullable = false, updatable = false)
	private Date date_ordered = new Date();
	
	@Column
	@NotNull
	private Long branch_id;
	
	@Column
	@NotNull
	private Boolean to_be_delivered;
	
	@Column
	private Long location_id;
	
	@Column(columnDefinition = "double default 0")
	@NotNull
	private Double total_amount;

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Date getDate_ordered() {
		return date_ordered;
	}

	public Long getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(Long branch_id) {
		this.branch_id = branch_id;
	}

	public Boolean getTo_be_delivered() {
		return to_be_delivered;
	}

	public void setTo_be_delivered(Boolean to_be_delivered) {
		this.to_be_delivered = to_be_delivered;
	}

	public Long getLocation_id() {
		return location_id;
	}

	public void setLocation_id(Long location_id) {
		this.location_id = location_id;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}



}
