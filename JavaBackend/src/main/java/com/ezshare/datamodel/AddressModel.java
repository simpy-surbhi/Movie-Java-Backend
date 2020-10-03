package com.ezshare.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AddressModel")
public class AddressModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="country")
	private String country;
	
	@Column(name="area")
	private String area;
	
	@Column(name="city")
	private String city;
	
	@Column(name="street")
	private String street;
	
	@Column(name="pincode")
	private String pincode;
	
	@ManyToOne
	@JoinColumn(name="fk_user")
	private UserModel user;
	
	@Column(name="createdon")
	private String  createdon;
	
	@Column(name="updatedon")
	private String  updatedon;
	
	public AddressModel() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}
}
