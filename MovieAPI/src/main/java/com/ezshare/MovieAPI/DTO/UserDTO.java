package com.ezshare.MovieAPI.DTO;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class UserDTO {
	
	private Long id;
	private String username;
	private String password;
	private String birthdate;
	private String gender;
	private String email;
	private String country;
	private String area;
	private String city;
	private String street;
	private String pincode;
	private String role;
	private String createdon;
	private String updatedon;

	public UserDTO() {
	
	}
	
	public UserDTO(Long id, String username, String password, String birthdate, String gender, String email,
			String country, String area, String city, String street, String pincode, String role, String createdon,
			String updatedon) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.birthdate = birthdate;
		this.gender = gender;
		this.email = email;
		this.country = country;
		this.area = area;
		this.city = city;
		this.street = street;
		this.pincode = pincode;
		this.role = role;
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("dd/mm/yyyy HH:mm:ss");
		System.out.println(ft.format(dNow));
		this.createdon = ft.format(dNow);
		this.updatedon = ft.format(dNow);
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public String encrypt() {
		try {	
	         // Encode using basic encoder
	         String base64encodedString = Base64.getEncoder().encodeToString(this.password.getBytes("utf-8"));
	         return base64encodedString;
		}catch(Exception e){
			return this.password;
		}
	}
	
	public String decrypt() {
		 // Decode
        byte[] base64decodedBytes = Base64.getDecoder().decode(this.password);
		try {
			return new String(base64decodedBytes, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return this.password;
		}
	}
}
