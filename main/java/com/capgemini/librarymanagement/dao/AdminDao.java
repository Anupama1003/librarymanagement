package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.beans.Users;

public interface AdminDao {
	
	public boolean addLibrarian(Users librarian);
	public boolean updateLibrarian(Users librarian);
	public boolean deleteLibrarian(String id);
	public Users searchLibrarian(String id);
	public List<Users> showAllLibrarianInfo();
	public List<Users> showAllStudentInfo();
	

}
