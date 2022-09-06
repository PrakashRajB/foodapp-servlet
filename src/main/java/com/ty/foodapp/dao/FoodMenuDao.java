package com.ty.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.foodapp.dto.FoodMenu;

public class FoodMenuDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	public FoodMenu addFoodMenu(FoodMenu menu) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
		return menu;
	}

	public List<FoodMenu> getAllFoodMenu() {

		String jpql = "select m from FoodMenu m";
		Query query = entityManager.createQuery(jpql);

		return query.getResultList();
	}

	public FoodMenu getFoodMenuById(int id) {
		return entityManager.find(FoodMenu.class, id);
	}

	public void updateFoodMenu(FoodMenu menu) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(menu);
		entityTransaction.commit();
	}

	public void deleteFoodMenubyId(int id) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		FoodMenu menu = getFoodMenuById(id);
		entityTransaction.begin();
		entityManager.remove(menu);
		entityTransaction.commit();
	}
}