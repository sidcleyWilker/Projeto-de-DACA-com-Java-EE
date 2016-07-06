package com.ifpb.daca.sidcley.controles.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifpb.daca.sidcley.Exception.DacaPersistenciaException;
import com.ifpb.daca.sidcley.Exception.DacaServiceException;
import com.ifpb.daca.sidcley.entidades.Pessoa;
import com.ifpb.daca.sidcley.service.PessoaService;

@Named
@ViewScoped
public class PessoaBean extends AbstractBean{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa;

	@Inject
	private PessoaService service;

	private List<Pessoa> pessoas;

	@PostConstruct
	public void init() {
		try {
			pessoas = service.getAll();
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
	}
	

	public void preRenderView() {
		if (pessoa == null) {
			pessoa = new Pessoa();
		}
	}


	public void initCadastroNovaPessoa() {
		this.pessoa = new Pessoa();
	}

	public void salvar() throws DacaPersistenciaException, DacaServiceException {
		if (pessoa.getId() != null) {
			service.update(pessoa);
			reportarMensagemDeSucesso("Atualizado");
		} else {
			service.save(pessoa);
			reportarMensagemDeSucesso("Salvo");
		}
		init();
		
	}

	public void remover() throws DacaPersistenciaException, DacaServiceException {
		service.delete(pessoa);
		init();
		reportarMensagemDeSucesso("Removido");
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
}
