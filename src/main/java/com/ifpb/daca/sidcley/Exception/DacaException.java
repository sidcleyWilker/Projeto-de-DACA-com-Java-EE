package com.ifpb.daca.sidcley.Exception;

public class DacaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DacaException(String mensagem) {
		super(mensagem);
	}

	public DacaException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}

}
