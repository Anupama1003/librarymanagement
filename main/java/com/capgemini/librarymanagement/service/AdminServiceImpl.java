package com.capgemini.librarymanagement.service;

import java.util.List;

import com.capgemini.librarymanagement.beans.Users;
import com.capgemini.librarymanagement.dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService {

	AdminDaoImpl dao = new AdminDaoImpl();
	@Override
	public boolean addLibrarian(Users librarian) {
		return  dao.addLibrarian(librarian);
	}

	@Override
	public boolean updateLibrarian(Users librarian) {
		return dao.updateLibrarian(librarian);
	}

	@Override
	public boolean deleteLibrarian(String id) {
		return dao.deleteLibrarian(id);
	}

	@Override
	public Users searchLibrarian(String id) {
		return dao.searchLibrarian(id);
	}

	@Override
	public List<Users> showAllLibrarianInfo() {
		return dao.showAllLibrarianInfo();
	}

	@Override
	public List<Users> showAllStudentInfo() {
		return dao.showAllStudentInfo();
	}

}
