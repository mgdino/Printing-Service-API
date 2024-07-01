package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long branch_id;
	
	@Column
	@NotNull
	private String branch_name;
	
	@Column
	@NotNull
	private Long branch_location_id;
	
	@Column
	@NotNull
	private String contact_number;

	public Long getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(Long branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public Long getBranch_location_id() {
		return branch_location_id;
	}

	public void setBranch_location_id(Long branch_location_id) {
		this.branch_location_id = branch_location_id;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	
	

}
