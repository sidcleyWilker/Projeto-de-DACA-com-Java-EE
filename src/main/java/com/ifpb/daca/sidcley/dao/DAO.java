package com.ifpb.daca.sidcley.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class DAO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
