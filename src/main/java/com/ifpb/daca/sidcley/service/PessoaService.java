package com.ifpb.daca.sidcley.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ifpb.daca.sidcley.Exception.DacaPersistenciaException;
import com.ifpb.daca.sidcley.Exception.DacaServiceException;
import com.ifpb.daca.sidcley.dao.PessoaDAO;
import com.ifpb.daca.sidcley.entidades.Pessoa;
import com.ifpb.daca.sidcley.util.TransacionalCdi;



public class PessoaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaDAO dao;
	
	@TransacionalCdi
	public void save(Pessoa pessoa) throws DacaServiceException {
		try {
			this.dao.save(pessoa);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	@TransacionalCdi
	public Pessoa update(Pessoa pessoa) throws DacaServiceException {
		try {
			return this.dao.update(pessoa);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	@TransacionalCdi
	public void delete(Pessoa pessoa) throws DacaServiceException {
		try {
			this.dao.delete(pessoa);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	public Pessoa getPessoaById(String login, String senha) throws DacaServiceException{
		try{
			return this.dao.getPessoaById(login, senha);
		}catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	public List<Pessoa> getAll() throws DacaServiceException{
		try{
			return this.dao.getAll();
		}catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
}
