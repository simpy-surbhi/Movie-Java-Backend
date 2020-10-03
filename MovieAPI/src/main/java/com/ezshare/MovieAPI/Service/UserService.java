package com.ezshare.MovieAPI.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;

import com.ezshare.MovieAPI.DTO.UserDTO;
import com.ezshare.Questionnaire.services.AdderessDAO;
import com.ezshare.Questionnaire.services.ContactDAO;
import com.ezshare.Questionnaire.services.UserDAO;
import com.ezshare.datamodel.AddressModel;
import com.ezshare.datamodel.ContactModel;
import com.ezshare.datamodel.UserModel;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

@Path("/user")
public class UserService {
	
	@Inject
	UserDAO userDAO;
	
	@Inject 
	AdderessDAO addressDAO;
	
	@Inject
	ContactDAO contactDAO;
	
	@POST
	@Path("/createUser")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response create(@RequestBody UserDTO user) {
		
		if (user.getUsername() == null || user.getPassword() == null) {
			return Response.serverError().build();
		}
		
		List<UserModel> listUserTemp = userDAO.authenticate("username", user.getUsername(), "password", user.encrypt());
		
		if (listUserTemp.size() == 0) {
			
			Date dNow = new Date( );
		    SimpleDateFormat ft = new SimpleDateFormat ("dd/mm/yyyy HH:mm:ss");
			System.out.println(ft.format(dNow));
			user.setCreatedon(ft.format(dNow));
			user.setUpdatedon(ft.format(dNow));
			
			UserModel usermodel = new UserModel();
			usermodel.setUsername(user.getUsername());
			usermodel.setPassword(user.encrypt());
			usermodel.setRole(user.getRole());
			usermodel.setCreatedon(user.getCreatedon());
			usermodel.setUpdatedon(user.getUpdatedon());
			
			ContactModel contact = new ContactModel();
			contact.setBirthdate(user.getBirthdate());
			contact.setEmail(user.getEmail());
			contact.setGender(user.getGender());
			contact.setUser(usermodel);
			contact.setCreatedon(user.getCreatedon());
			contact.setUpdatedon(user.getUpdatedon());
			
			AddressModel address =  new AddressModel();
			address.setCountry(user.getCountry());
			address.setArea(user.getArea());
			address.setCity(user.getCity());
			address.setStreet(user.getStreet());
			address.setPincode(user.getPincode());
			address.setUser(usermodel);
			address.setCreatedon(user.getCreatedon());
			address.setUpdatedon(user.getUpdatedon());
						
			try {
				userDAO.create(usermodel);
				contactDAO.create(contact);
				addressDAO.create(address);
				
				user.setId(usermodel.getId());
				
				return Response.status(Status.OK).entity(user).build();
			} catch (Exception e) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("error", "username is already exist.");
				return Response.status(Status.NOT_ACCEPTABLE).entity(map).build();
			}
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("error", "username is already exist.");
			return Response.status(Status.UNAUTHORIZED).entity(map).build();
		}
	}
	
	@POST
	@Path("/authenticateUser")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response authenticate(@RequestBody UserDTO user) {
		if (user.getUsername() == null || user.getPassword() == null) {
			return Response.serverError().build();
		}
		
		List<UserModel> listUsermodel = userDAO.authenticate("username", user.getUsername(), "password", user.encrypt());
		if (listUsermodel.size() > 0) {
			
			UserModel usermodel = listUsermodel.get(0);
			if(usermodel.getUsername().equalsIgnoreCase(user.getUsername()) && usermodel.decrypt().equalsIgnoreCase(user.getPassword())) {
				
				ContactModel contact = contactDAO.getByOtherColumnId(usermodel.getId(), "fk_user").get(0);
				AddressModel address = addressDAO.getByOtherColumnId(usermodel.getId(), "fk_user").get(0);
				
				user.setId(usermodel.getId());
				user.setRole(usermodel.getRole());
				user.setUsername(usermodel.getUsername());
				user.setGender(contact.getGender());
				user.setBirthdate(contact.getBirthdate());
				user.setEmail(contact.getEmail());
				user.setCountry(address.getCountry());
				user.setArea(address.getArea());
				user.setCity(address.getCity());
				user.setStreet(address.getStreet());
				user.setPincode(address.getPincode());
				user.setCreatedon(usermodel.getCreatedon());
				user.setUpdatedon(usermodel.getUpdatedon());
				
				return Response.status(Status.OK).entity(user).build();
			}else {
				Map<String, String> map = new HashMap<String, String>();
				map.put("error", "Wrong Credentials");
				return Response.status(Status.UNAUTHORIZED).entity(map).build();
			}
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("error", "Wrong Credentials");
			return Response.status(Status.UNAUTHORIZED).entity(map).build();
		}
	}
}
