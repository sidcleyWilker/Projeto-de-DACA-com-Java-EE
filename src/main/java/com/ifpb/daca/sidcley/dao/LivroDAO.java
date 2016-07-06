package com.ifpb.daca.sidcley.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.ifpb.daca.sidcley.Exception.DacaPersistenciaException;
import com.ifpb.daca.sidcley.entidades.Livro;

public class LivroDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void save(Livro livro) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		try {
			em.persist(livro);
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar salvar o livro.", pe);
		}
	}

	public Livro update(Livro livro) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		Livro resultado = livro;
		try {
			resultado = em.merge(livro);
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar atualizar o livro.", pe);
		}
		return resultado;
	}

	public void delete(Livro livro) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		try {
			livro = em.merge(livro);
			em.remove(livro);
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar remover o livro.", pe);
		}
	}

	public List<Livro> getAll() throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		List<Livro> resultado = null;
		try {
			TypedQuery<Livro> query = em.createQuery("SELECT l FROM Livro l", Livro.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar recuperar os livros.", pe);
		}
		return resultado;
	}

	public Livro getLivroByIsbn(String isbn) throws DacaPersistenciaException {
		Livro resultado = null;
		EntityManager em = getEntityManager();
		try {
			TypedQuery<Livro> query = em.createQuery("SELECT l FROM Livro l WHERE l.isbn=:isbn", Livro.class);
			query.setParameter("isbn", isbn);
			resultado = query.getSingleResult();
		} catch (NoResultException l) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar recuperar o livro.", l);
		}
		return resultado;
	}
}
