package com.ifpb.daca.sidcley.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.ifpb.daca.sidcley.Exception.DacaServiceException;
import com.ifpb.daca.sidcley.entidades.Fornecedor;
import com.ifpb.daca.sidcley.service.FornecedorService;

@FacesConverter(forClass = Fornecedor.class)
public class FornecedorConverte implements Converter{

	@Inject
	private FornecedorService service;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		try {
			return service.getbyCpfCnpj(value);
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
		if(value != null){
			Fornecedor fornecedor = (Fornecedor) value;
			return fornecedor.getCpfCnpj();
		}
		return null;
	}

}
