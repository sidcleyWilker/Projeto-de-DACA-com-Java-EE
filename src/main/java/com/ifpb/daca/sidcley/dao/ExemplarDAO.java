package com.ifpb.daca.sidcley.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.ifpb.daca.sidcley.Exception.DacaPersistenciaException;
import com.ifpb.daca.sidcley.entidades.Exemplar;

public class ExemplarDAO extends DAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void save(Exemplar exemplar) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		try {
			em.persist(exemplar);
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar salvar o exemplar.", pe);
		}
	}

	public Exemplar update(Exemplar exemplar) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		Exemplar resultado = exemplar;
		try {
			resultado = em.merge(exemplar);
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar atualizar o exemplar.", pe);
		}
		return resultado;
	}

	public void delete(Exemplar exemplar) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		try {
			exemplar = em.merge(exemplar);
			if (exemplar.getFornecedor() != null) {
				Collection<Exemplar> exemplaresFornecidos = exemplar.getFornecedor().getExemplaresFornecidos();
				if (exemplaresFornecidos != null) {
					exemplaresFornecidos.remove(exemplar);
				}
			}
			if (exemplar.getLivro() != null) {
				Collection<Exemplar> exemplares = exemplar.getLivro().getExemplares();
				if (exemplares != null) {
					exemplares.remove(exemplar);
				}
			}
			em.remove(exemplar);
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar remover o exemplar.", pe);
		}
	}

	public List<Exemplar> getAll() throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		List<Exemplar> resultado = null;
		try {
			TypedQuery<Exemplar> query = em.createQuery("SELECT e FROM Exemplar e", Exemplar.class);
			resultado = query.getResultList();
		}  catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar recuperar os exemplares.", pe);
		}
		return resultado;
	}
	
	public Exemplar getByCodigoItem(String codigoItem) throws DacaPersistenciaException{
		Exemplar resultado = null;
		EntityManager em = getEntityManager();
		String jpql = "SELECT e FROM Exemplar e WHERE e.codigoItem=:codigoItem";
		try{
			TypedQuery<Exemplar> query = em.createQuery(jpql, Exemplar.class);
			query.setParameter("codigoItem", codigoItem);
			resultado = query.getSingleResult();
		}catch (NoResultException e) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar recuperar o exemplar.", e);
		}
		return resultado;
	}
}
