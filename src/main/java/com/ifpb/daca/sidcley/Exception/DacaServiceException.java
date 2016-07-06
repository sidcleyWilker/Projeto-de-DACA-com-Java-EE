package com.ifpb.daca.sidcley.Exception;

import com.ifpb.daca.sidcley.Exception.DacaException;

public class DacaServiceException extends DacaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DacaServiceException(String mensagem) {
		super(mensagem);
	}

	public DacaServiceException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}
}
