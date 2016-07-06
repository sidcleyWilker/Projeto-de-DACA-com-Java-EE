package com.ifpb.daca.sidcley.controles.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifpb.daca.sidcley.Exception.DacaServiceException;
import com.ifpb.daca.sidcley.entidades.Exemplar;
import com.ifpb.daca.sidcley.entidades.Fornecedor;
import com.ifpb.daca.sidcley.entidades.Livro;
import com.ifpb.daca.sidcley.service.ExemplarService;
import com.ifpb.daca.sidcley.service.FornecedorService;
import com.ifpb.daca.sidcley.service.LivroService;

@Named
@ViewScoped
public class ExemplarBean extends AbstractBean{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Exemplar exemplar;
	
	@Inject
	private ExemplarService exemplarService;
	
	private List<Exemplar> exemplares;
	
	@Inject
	private LivroService livroService;
	
	@Inject
	private FornecedorService fornecedorService;
	
	@PostConstruct
	public void init(){
		try {
			exemplares = exemplarService.getAll();
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
	}
	
	public void preRenderView() {
		if (exemplar == null){
			exemplar = new Exemplar();
			exemplar.setReservado(false);
			exemplar.setDisponivel(true);
		}
	}
	
	public List<Livro> sugerirLivro(String consulta) throws DacaServiceException{
		List<Livro> livrosSurgeridos = new ArrayList<>();
		for(Livro livro : this.livroService.getAll()){
			if(livro.getIsbn().toLowerCase().startsWith(consulta.toLowerCase())){
				livrosSurgeridos.add(livro);
			}
		}
		return livrosSurgeridos;
	}
	
	public List<Fornecedor> sugerirFornecedor(String consulta) throws DacaServiceException{
		List<Fornecedor> fornecedoresSurgeridos = new ArrayList<>();
		for(Fornecedor fornecedor : fornecedorService.getAll()){
			if(fornecedor.getCpfCnpj().toLowerCase().startsWith(consulta.toLowerCase())){
				fornecedoresSurgeridos.add(fornecedor);
			}
		}
		return fornecedoresSurgeridos;
	}
	
	public void iniciarNovoCadastroExemplar(){
		this.exemplar = new Exemplar();
	}
	
	public void salvar() throws DacaServiceException{
		if(this.exemplar.getId() != null){
			exemplarService.update(exemplar);
			reportarMensagemDeSucesso("Alterado");
		}else{
			exemplarService.save(exemplar);
			reportarMensagemDeSucesso("Salvo");
		}
		init();
	}
	
	public void remover() throws DacaServiceException{
		exemplarService.delete(exemplar);
		init();
		reportarMensagemDeSucesso("Removido");
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	public List<Exemplar> getExemplares() {
		return exemplares;
	}

	public void setExemplares(List<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}
}
