package com.ifpb.daca.sidcley.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.ifpb.daca.sidcley.Exception.DacaServiceException;
import com.ifpb.daca.sidcley.entidades.Exemplar;
import com.ifpb.daca.sidcley.service.ExemplarService;

@FacesConverter(forClass = Exemplar.class)
public class ExemplarConverte implements Converter{

	@Inject
	private ExemplarService service;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		try {
			return service.getByCodigoItem(value);
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
			Exemplar exemplar = (Exemplar) value;
			return exemplar.getCodigoItem();
		}
		return null;
	}

}
