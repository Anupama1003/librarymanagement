package com.capgemini.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.beans.BooksInventory;
import com.capgemini.librarymanagement.beans.BooksRegistration;
import com.capgemini.librarymanagement.beans.BooksTransaction;
import com.capgemini.librarymanagement.beans.Users;

@Repository
public class LibrarianDaoImpl implements LibrarianDao {
	@Autowired
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager entityManager;
	EntityTransaction transaction;

	@Override
	public boolean addBook(BooksInventory book) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isadded = false;
		try {
			transaction.begin();
			entityManager.persist(book);
			transaction.commit();
			isadded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isadded;
	}// end of add book

	@Override
	public boolean updateBook(BooksInventory book) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isadded = false;
		try {
			if (searchBook(book.getBookId()) == null) {
				return isadded;
			} else {
				transaction.begin();
				entityManager.merge(book);
				transaction.commit();
				isadded = true;
			}
		} catch (Exception e) {
			transaction.rollback();
			return isadded;
		}
		entityManager.close();
		return isadded;
	}// end of update librarian

	@Override
	public boolean deleteBook(BooksInventory book) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		try {
			Users user = null;
			user = entityManager.find(Users.class, book);
			if (user == null) {
				return false;
			} else {
				transaction.begin();
				entityManager.remove(user);
				transaction.commit();

			}
		} catch (Exception e) {
			transaction.rollback();
			return false;
		}
		entityManager.close();
		return true;
	}//

	@Override
	public boolean getRequestBook(BooksTransaction book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BooksTransaction> showAllissuedDetails() {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		List<BooksTransaction> booksTransaction = null;
		try {
			transaction.begin();
			TypedQuery<BooksTransaction> query = entityManager.createQuery("from BooksTransaction",
					BooksTransaction.class);
			booksTransaction = query.getResultList();
			transaction.commit();
			entityManager.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return booksTransaction;
	}

	@Override
	public List<BooksRegistration> showRequestDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addStudent(Users student) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isadded = false;
		try {
			transaction.begin();
			entityManager.persist(student);
			transaction.commit();
			isadded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isadded;
	}// end of add book

	@Override
	public boolean updateStudentProfile(Users student) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isadded = false;
		try {
			if (searchBook(student.getUserId()) == null) {
				return isadded;
			} else {
				transaction.begin();
				entityManager.merge(student);
				transaction.commit();
				isadded = true;
			}
		} catch (Exception e) {
			transaction.rollback();
			return isadded;
		}
		entityManager.close();
		return isadded;
	}// end of update librarian

	@Override
	public boolean deleteStudentProfile(String id) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		try {
			Users user = null;
			user = entityManager.find(Users.class, id);
			if (user == null) {
				return false;
			} else {
				transaction.begin();
				entityManager.remove(user);
				transaction.commit();

			}
		} catch (Exception e) {
			transaction.rollback();
			return false;
		}
		entityManager.close();
		return true;
	}//

	@Override
	public Users searchStudentProfile(String id) {
		entityManager = entityManagerFactory.createEntityManager();
		Users user = null;
		user = entityManager.find(Users.class, id);
		if (user != null) {

		} else {
			return user;
		}
		entityManager.close();
		return user;
	}// end of searchEmployee

	@Override
	public Users searchBook(String id) {
		entityManager = entityManagerFactory.createEntityManager();
		Users user = null;
		user = entityManager.find(Users.class, id);
		if (user != null) {

		} else {
			return user;
		}
		entityManager.close();
		return user;
	}// end of searchEmployee

	@Override
	public Boolean register(Users student) {
		try {
			student.setType("student");
			if (searchStudentProfile(student.getUserId()) != null) {
				return false;
			} else {
				transaction.begin();
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}
}
