package com.ifpb.daca.sidcley.Exception;

public class DacaPersistenciaException extends DacaException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DacaPersistenciaException(String mensagem) {
		super(mensagem);
	}

	public DacaPersistenciaException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}

}
