package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.beans.Users;

public interface CommonDao {
	
	public Users Login(String id, String password);
	
	

}
