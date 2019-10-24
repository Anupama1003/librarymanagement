package com.capgemini.librarymanagement.service;

import com.capgemini.librarymanagement.beans.BooksInventory;
import com.capgemini.librarymanagement.beans.BooksTransaction;
import com.capgemini.librarymanagement.beans.Users;

public class StudentServiceImpl implements StudentService {

	StudentServiceImpl dao = new StudentServiceImpl();
	@Override
	public Boolean register(Users student) {
		return dao.register(student);
	}

	@Override
	public BooksInventory searchBook(BooksInventory bookName) {
		return dao.searchBook(bookName);
	}

	@Override
	public BooksInventory requestBook(BooksInventory bookId) {
		return dao.requestBook(bookId);
	}

	@Override
	public BooksInventory cancellRequest(BooksInventory bookId) {
		return dao.cancellRequest(bookId);
	}

	@Override
	public BooksTransaction responseRequestBook() {
		return dao.responseRequestBook();
	}

}
