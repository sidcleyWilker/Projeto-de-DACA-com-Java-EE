package com.ifpb.daca.sidcley.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.ifpb.daca.sidcley.entidades.Emprestimo;

public class EmprestimoDAO extends DAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void save(Emprestimo emprestimo) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(emprestimo);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}

	public Emprestimo update(Emprestimo emprestimo) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Emprestimo resultado = emprestimo;
		try {
			resultado = em.merge(emprestimo);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		return resultado;
	}

	public void delete(Emprestimo emprestimo) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			emprestimo = em.merge(emprestimo);
			em.remove(emprestimo);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}


	public List<Emprestimo> getAll() {
		EntityManager em = getEntityManager();
		List<Emprestimo> resultado = null;
		try {
			TypedQuery<Emprestimo> query = em.createQuery("SELECT e FROM Emprestimo e", Emprestimo.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} finally {
			em.close();
		}
		return resultado;
	}
	
}
