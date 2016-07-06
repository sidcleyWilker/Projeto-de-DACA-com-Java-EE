package com.ifpb.daca.sidcley.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.ifpb.daca.sidcley.Exception.DacaPersistenciaException;
import com.ifpb.daca.sidcley.Exception.DacaServiceException;
import com.ifpb.daca.sidcley.dao.LivroDAO;
import com.ifpb.daca.sidcley.entidades.Livro;
import com.ifpb.daca.sidcley.util.TransacionalCdi;

public class LivroService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private LivroDAO dao;

	@TransacionalCdi
	public void save(Livro livro) throws DacaServiceException {
		try {
			this.dao.save(livro);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}

	@TransacionalCdi
	public Livro update(Livro livro) throws DacaServiceException {
		try {
			return this.dao.update(livro);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}

	@TransacionalCdi
	public void delete(Livro livro) throws DacaServiceException {
		try {
			this.dao.delete(livro);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}

	public Livro getLivroByIsbn(String isbn) throws DacaServiceException {
		try {
			return this.dao.getLivroByIsbn(isbn);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}

	public List<Livro> getAll() throws DacaServiceException {
		try {
			return this.dao.getAll();
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
}
