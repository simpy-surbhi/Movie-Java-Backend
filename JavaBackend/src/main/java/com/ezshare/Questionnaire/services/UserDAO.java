package com.ezshare.Questionnaire.services;

import java.util.Map;
import com.ezshare.datamodel.UserModel;

public class UserDAO extends GenericDAO<UserModel, String> {

	@Override
	public void setParameters(Map<String, Object> parameters, UserModel criteria) {
		parameters.put("pTitle", criteria.getUsername());
	}
}