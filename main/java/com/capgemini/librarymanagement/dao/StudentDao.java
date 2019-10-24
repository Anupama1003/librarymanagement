package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.beans.BooksInventory;
import com.capgemini.librarymanagement.beans.BooksTransaction;
import com.capgemini.librarymanagement.beans.Users;

public interface StudentDao {
	
	
	public BooksInventory searchBook(BooksInventory bookName);
	public BooksInventory requestBook(BooksInventory bookId);
	public BooksInventory cancellRequest(BooksInventory bookId);
	public BooksTransaction responseRequestBook();
	

}
