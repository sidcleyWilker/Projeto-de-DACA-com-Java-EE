package com.ifpb.daca.sidcley.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.ifpb.daca.sidcley.Exception.DacaPersistenciaException;
import com.ifpb.daca.sidcley.entidades.Fornecedor;

public class FornecedorDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void save(Fornecedor fornecedor) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		try {
			em.persist(fornecedor);
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar salvar o fornecedor.", pe);
		}
	}

	public Fornecedor update(Fornecedor fornecedor) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		Fornecedor resultado = fornecedor;
		try {
			resultado = em.merge(fornecedor);
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar atualizar o fornecedor.", pe);
		}
		return resultado;
	}

	public void delete(Fornecedor fornecedor) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		try {
			fornecedor = em.merge(fornecedor);
			em.remove(fornecedor);	
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar remover o fornecedor.", pe);
		}
	}

	public List<Fornecedor> getAll() throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		List<Fornecedor> resultado = null;
		try {
			TypedQuery<Fornecedor> query = em.createQuery("SELECT f FROM Fornecedor f", Fornecedor.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar recuperar os fornecedores.", pe);
		}
		return resultado;
	}

	public Fornecedor getbyCpfCnpj(String cpfCnpj) throws DacaPersistenciaException {
		Fornecedor resultado = null;
		EntityManager em = getEntityManager();
		String jpql = "SELECT f FROM Fornecedor f WHERE f.cpfCnpj=:cpfCnpj";
		try {
			TypedQuery<Fornecedor> query = em.createQuery(jpql, Fornecedor.class);
			query.setParameter("cpfCnpj", cpfCnpj);
			resultado = query.getSingleResult();
		} catch (NoResultException f) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar recuperar o fornecedor.", f);
		}
		return resultado;
	}

}
