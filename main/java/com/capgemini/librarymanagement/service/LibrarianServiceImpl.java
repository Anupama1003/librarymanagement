package com.capgemini.librarymanagement.service;

import java.util.List;

import com.capgemini.librarymanagement.beans.BooksInventory;
import com.capgemini.librarymanagement.beans.BooksRegistration;
import com.capgemini.librarymanagement.beans.BooksTransaction;
import com.capgemini.librarymanagement.beans.Users;
import com.capgemini.librarymanagement.dao.LibrarianDaoImpl;

public class LibrarianServiceImpl implements LibrarianService {

	LibrarianDaoImpl dao = new LibrarianDaoImpl();

	@Override
	public boolean addBook(BooksInventory book) {
		return dao.addBook(book);
	}

	@Override
	public boolean updateBook(BooksInventory book) {
		return dao.updateBook(book);
	}

	@Override
	public boolean deleteBook(BooksInventory book) {
		return dao.deleteBook(book);
	}

	@Override
	public boolean getRequestBook(BooksTransaction book) {
		return dao.getRequestBook(book);
	}

	@Override
	public boolean addStudent(Users student) {
		return dao.addStudent(student);
	}

	@Override
	public boolean updateStudentProfile(Users student) {
		return dao.updateStudentProfile(student);
	}

	@Override
	public boolean deleteStudentProfile(String id) {
		return dao.deleteStudentProfile(id);
	}

	@Override
	public Users searchStudentProfile(String id) {
		return dao.searchStudentProfile(id);
	}

	@Override
	public Users searchBook(String bookId) {
		return dao.searchBook(bookId);
	}

	@Override
	public List<BooksTransaction> showAllissuedDetails() {
		return dao.showAllissuedDetails();
	}

	@Override
	public List<BooksRegistration> showRequestDetails() {
		return dao.showRequestDetails();
	}
}
