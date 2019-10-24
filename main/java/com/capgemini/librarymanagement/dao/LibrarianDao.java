package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.beans.BooksInventory;
import com.capgemini.librarymanagement.beans.BooksRegistration;
import com.capgemini.librarymanagement.beans.BooksTransaction;
import com.capgemini.librarymanagement.beans.Users;

public interface LibrarianDao {
	public Boolean register(Users student);
	public boolean addBook(BooksInventory book);
	public boolean updateBook(BooksInventory book);
	public boolean deleteBook(BooksInventory book);
	public boolean getRequestBook(BooksTransaction book);
	public boolean addStudent(Users student);
	public boolean updateStudentProfile(Users student);
	public boolean deleteStudentProfile(String id);
	public Users searchStudentProfile(String id);
	public Users searchBook(String bookId);
	public List<BooksTransaction> showAllissuedDetails();
	public List<BooksRegistration> showRequestDetails();
}
