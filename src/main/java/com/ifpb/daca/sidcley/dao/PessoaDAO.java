package com.ifpb.daca.sidcley.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.ifpb.daca.sidcley.Exception.DacaPersistenciaException;
import com.ifpb.daca.sidcley.entidades.Emprestimo;
import com.ifpb.daca.sidcley.entidades.Pessoa;


public class PessoaDAO extends DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void save(Pessoa pessoa)throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		try {
			em.persist(pessoa);
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar salvar a pessoa.", pe);
		}
	}

	public Pessoa update(Pessoa pessoa) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		Pessoa resultado = pessoa;
		try {
			resultado = em.merge(pessoa);
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar atualizar a pessoa.", pe);
		}
		return resultado;
	}

	public void delete(Pessoa pessoa) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		try {
			pessoa = em.merge(pessoa);
			em.remove(pessoa);
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar remover a pessoa.", pe);
		}
	}

	public List<Pessoa> getAll() throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		List<Pessoa> resultado = null;
		try {
			TypedQuery<Pessoa> query = em.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar recuperar as pessoas.", pe);
		}
		return resultado;
	}

	public Pessoa getPessoaById(String login, String senha) throws DacaPersistenciaException {
		Pessoa resultado = null;
		EntityManager em = getEntityManager();
		String jpql = "SELECT p FROM Pessoa p WHERE p.login=:login and p.senha=:senha";
		try{
			TypedQuery<Pessoa> query = em.createQuery(jpql, Pessoa.class);
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			resultado = query.getSingleResult();
		}catch(NoResultException n){
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar recuperar a pessoa.", n);
		}
		return resultado;
	}	
	
	public List<Pessoa> emprestimosJaFeitos(Pessoa pessoa){
		return null;
	}
	
	public List<Emprestimo> emprestimosFeitos(Date dataAtual, Pessoa pessoa){
		return null;
	}
}
