package com.ezshare.Questionnaire.services;

import java.util.Map;

import com.ezshare.datamodel.ContactModel;

public class ContactDAO extends GenericDAO<ContactModel, String> {

	@Override
	public void setParameters(Map<String, Object> parameters, ContactModel criteria) {
		parameters.put("pTitle", criteria.getEmail());
	}
}