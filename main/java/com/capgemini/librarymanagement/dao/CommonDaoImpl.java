package com.capgemini.librarymanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.beans.Users;

@Repository
public class CommonDaoImpl implements CommonDao {

	@Autowired
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager entityManager;
	EntityTransaction transaction;

	@Override
	public Users Login(String id, String password) {
		Users admin = null;
		String jpql = "from Users where id= :id  and password= :pw  and type='admin'";
		Query query = (Query) entityManager.createQuery(jpql);
		query.setParameter("id", id);
		query.setParameter("pw", password);
		Object obj = query.uniqueResult();
		admin = (Users) obj;
		if (obj != null) {
			return admin;
		} else {
			return admin;
		}

	}

}
