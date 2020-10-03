package com.ezshare.Questionnaire.services;

import java.util.Map;

import com.ezshare.datamodel.AddressModel;

public class AdderessDAO extends GenericDAO<AddressModel, String> {

	@Override
	public void setParameters(Map<String, Object> parameters, AddressModel criteria) {
		parameters.put("pTitle", criteria.getPincode());
	}
}