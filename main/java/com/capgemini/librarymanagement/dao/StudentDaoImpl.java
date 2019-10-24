package com.capgemini.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.beans.BooksInventory;
import com.capgemini.librarymanagement.beans.BooksTransaction;
import com.capgemini.librarymanagement.beans.Users;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager entityManager;
	EntityTransaction transaction;

	@Override
	public BooksInventory searchBook(BooksInventory bookName) {
		entityManager = entityManagerFactory.createEntityManager();
		BooksInventory book = null;
		book = entityManager.find(BooksInventory.class, bookName);
		if (book != null) {

		} else {
			return book;
		}
		entityManager.close();
		return book;
	}// end of searchEmployee

	@Override
	public BooksInventory requestBook(BooksInventory bookId) {
		entityManager = entityManagerFactory.createEntityManager();
		BooksInventory book = null;
		book = entityManager.find(BooksInventory.class, bookId);
		if (book != null) {

		} else {
			return book;
		}
		entityManager.close();
		return book;
	}

	@Override
	public BooksInventory cancellRequest(BooksInventory bookId) {
		BooksInventory book = null;
		List<BooksInventory> inventoryList = null;
		try {
			transaction.begin();
			TypedQuery<BooksInventory> query = entityManager.createQuery("from BooksInventory where bookId = :id",
					BooksInventory.class);
			query.setParameter("id", bookId);
			inventoryList = query.getResultList();
			if (inventoryList.size() > 0) {
				book = inventoryList.get(0);
				entityManager.remove(book);
				transaction.commit();
				entityManager.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public BooksTransaction responseRequestBook() {
		// TODO Auto-generated method stub
		return null;
	}

}
