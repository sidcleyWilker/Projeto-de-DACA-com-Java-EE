package com.ifpb.daca.sidcley.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ifpb.daca.sidcley.Exception.DacaPersistenciaException;
import com.ifpb.daca.sidcley.Exception.DacaServiceException;
import com.ifpb.daca.sidcley.dao.ExemplarDAO;
import com.ifpb.daca.sidcley.entidades.Exemplar;
import com.ifpb.daca.sidcley.util.TransacionalCdi;

public class ExemplarService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ExemplarDAO dao;

	@TransacionalCdi
	public void save(Exemplar exemplar) throws DacaServiceException {
		try {
			this.dao.save(exemplar);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}

	@TransacionalCdi
	public Exemplar update(Exemplar exemplar) throws DacaServiceException {
		try {
			return this.dao.update(exemplar);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}

	@TransacionalCdi
	public void delete(Exemplar exemplar) throws DacaServiceException {
		try {
			this.dao.delete(exemplar);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	public List<Exemplar> getAll() throws DacaServiceException{
		try {
			return this.dao.getAll();
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	public Exemplar getByCodigoItem(String codigoItem) throws DacaServiceException{
		try {
			return this.dao.getByCodigoItem(codigoItem);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
}
