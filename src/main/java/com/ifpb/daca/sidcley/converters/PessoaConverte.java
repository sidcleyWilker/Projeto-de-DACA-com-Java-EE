package com.ifpb.daca.sidcley.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ifpb.daca.sidcley.Exception.DacaServiceException;
import com.ifpb.daca.sidcley.entidades.Pessoa;
import com.ifpb.daca.sidcley.service.PessoaService;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverte implements Converter {

	private PessoaService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		String loginSenha[] = new String[2];
		loginSenha = value.split(";");
		
		try {
			return service.getPessoaById(loginSenha[0], loginSenha[1]);
		} catch (DacaServiceException e) {
			String msgErroStr = String.format(
					"Erro de conversão! Não foi possivel realizar a conversão da string '%s' para o tipo esperado.",
					value);
			FacesMessage msgErro = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgErroStr, msgErroStr);
			throw new ConverterException(msgErro);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Pessoa pessoa = (Pessoa) value;
			if (pessoa.getId() == null) {
				return null;
			}
			return pessoa.getLogin() + ";" + pessoa.getSenha();
		}
		return null;
	}
}
