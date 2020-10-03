package com.ezshare.datamodel;


import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserModel")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Column(name="createdon")
	private String  createdon;
	
	@Column(name="updatedon")
	private String  updatedon;
	
	public UserModel() {
		
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
