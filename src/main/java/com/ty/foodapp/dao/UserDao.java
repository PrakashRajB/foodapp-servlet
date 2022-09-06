package com.ty.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.foodapp.dto.User;

public class UserDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	public User saveUser(User user) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

		return user;
	}

	public User  validateUser(String email, String password) {
		
		String jpql = "select u from User u where email=?1 and password=?2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);

		List<User> users = query.getResultList();

		return  (users.isEmpty()) ? null:users.get(0);
	}
}
