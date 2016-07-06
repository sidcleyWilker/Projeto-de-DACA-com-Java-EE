package com.ifpb.daca.sidcley.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ifpb.daca.sidcley.Exception.DacaPersistenciaException;
import com.ifpb.daca.sidcley.Exception.DacaServiceException;
import com.ifpb.daca.sidcley.dao.FornecedorDAO;
import com.ifpb.daca.sidcley.entidades.Fornecedor;
import com.ifpb.daca.sidcley.util.TransacionalCdi;

public class FornecedorService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FornecedorDAO dao;

	@TransacionalCdi
	public void save(Fornecedor fornecedor) throws DacaServiceException {
		try {
			this.dao.save(fornecedor);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}

	@TransacionalCdi
	public Fornecedor update(Fornecedor fornecedor) throws DacaServiceException {
		try {
			return this.dao.update(fornecedor);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}

	@TransacionalCdi
	public void delete(Fornecedor fornecedor) throws DacaServiceException {
		try {
			this.dao.delete(fornecedor);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	public List<Fornecedor> getAll() throws DacaServiceException {
		try {
			return this.dao.getAll();
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	public Fornecedor getbyCpfCnpj(String cpfCnpj) throws DacaServiceException{
		try {
			return this.dao. getbyCpfCnpj(cpfCnpj);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
}
