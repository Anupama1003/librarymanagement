package com.capgemini.librarymanagement.service;

import java.util.List;

import com.capgemini.librarymanagement.beans.Users;

public interface AdminService {
	public boolean addLibrarian(Users librarian);
	public boolean updateLibrarian(Users librarian);
	public boolean deleteLibrarian(String id);
	public Users searchLibrarian(String id);
	public List<Users> showAllLibrarianInfo();
	public List<Users> showAllStudentInfo();

}
