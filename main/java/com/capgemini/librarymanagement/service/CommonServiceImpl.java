package com.capgemini.librarymanagement.service;

import com.capgemini.librarymanagement.beans.Users;
import com.capgemini.librarymanagement.dao.CommonDaoImpl;

public class CommonServiceImpl implements CommonService{

	CommonDaoImpl dao = new CommonDaoImpl();
	@Override
	public Users Login(String id, String password) {
		return dao.Login(id, password);
	}
}
