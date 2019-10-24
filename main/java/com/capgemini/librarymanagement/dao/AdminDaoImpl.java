package com.capgemini.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.beans.Users;

@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager entityManager;
	EntityTransaction transaction;

	@Override
	public boolean addLibrarian(Users librarian) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isadded = false;
		try {
			transaction.begin();
			entityManager.persist(librarian);
			transaction.commit();
			isadded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isadded;
	}// end of add Librarian

	@Override
	public boolean updateLibrarian(Users librarian) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isadded = false;
		try {
			if (searchLibrarian(librarian.getUserId()) == null) {
				return isadded;
			} else {
				transaction.begin();
				entityManager.merge(librarian);
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
	public boolean deleteLibrarian(String id) {
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
	public List<Users> showAllLibrarianInfo() {
		entityManager = entityManagerFactory.createEntityManager();
		String jpqa = "from Users";
		Query query = entityManager.createQuery(jpqa);
		List<Users> allUsers = null;

		try {
			allUsers = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return allUsers;
	}

	@Override
	public List<Users> showAllStudentInfo() {
		entityManager = entityManagerFactory.createEntityManager();
		String jpqa = "from Users";
		Query query = entityManager.createQuery(jpqa);
		List<Users> allUsers = null;

		try {
			allUsers = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return allUsers;
	}

	@Override
	public Users searchLibrarian(String id) {
		entityManager = entityManagerFactory.createEntityManager();
		Users user = null;
		user = entityManager.find(Users.class, id);
		if (user != null) {

		} else {
			return user;
		}
		entityManager.close();
		return user;
	}// end of searchLibrarian
}
