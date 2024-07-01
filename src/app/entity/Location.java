package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long location_id;
	
	@Column
	@NotNull
	private String location_name;
	
	@Column
	@Range(min=-90, max=90)
	private Double latitude;
	
	@Column
	@Range(min=-180, max=180)
	private Double longnitude;

	public Long getLocationId() {
		return location_id;
	}
	public void setId(Long location_id) {
		this.location_id = location_id;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongnitude() {
		return longnitude;
	}
	public void setLongnitude(Double longnitude) {
		this.longnitude = longnitude;
	}
	@Override
	public String toString() {
		return "Location [id=" + location_id + ", location_name=" + location_name + ", latitude=" + latitude + ", longnitude="
				+ longnitude + "]";
	}
	
	
}


