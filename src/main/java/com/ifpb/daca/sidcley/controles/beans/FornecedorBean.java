package com.ifpb.daca.sidcley.controles.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifpb.daca.sidcley.Exception.DacaServiceException;
import com.ifpb.daca.sidcley.entidades.Fornecedor;
import com.ifpb.daca.sidcley.service.FornecedorService;

@Named
@javax.faces.view.ViewScoped
public class FornecedorBean extends AbstractBean{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private FornecedorService service;
	
	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;
	
	@PostConstruct
	public void init(){
		try {
			fornecedores = service.getAll();
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
	}
	
	
	public void preRenderView() {
		if(fornecedor == null){
			fornecedor = new Fornecedor();
		}
	}
	
	public void initCadastroNovaFornecedor(){
		this.fornecedor = new Fornecedor();
	}
	
	public void salvar() throws DacaServiceException{
		if(fornecedor.getId() !=  null){
			service.update(fornecedor);
			reportarMensagemDeSucesso("Alterado");
		}else{
			service.save(fornecedor);
			reportarMensagemDeSucesso("Salvo");
		}
		init();
	}
	
	public void remover() throws DacaServiceException{
		service.delete(fornecedor);
		init();
		reportarMensagemDeSucesso("Removido");
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
}
