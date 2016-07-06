package com.ifpb.daca.sidcley.controles.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifpb.daca.sidcley.Exception.DacaServiceException;
import com.ifpb.daca.sidcley.entidades.Exemplar;
import com.ifpb.daca.sidcley.entidades.Livro;
import com.ifpb.daca.sidcley.service.LivroService;

@Named
@ViewScoped
public class LivroBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Livro livro;

	@Inject
	private LivroService service;
	
	
	private List<String> estados = new ArrayList<>();
	private List<Livro> livros;

	@PostConstruct
	public void init() {
		try {
			livros = service.getAll();
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
	}

	public LivroBean() {
		estados.add("AC");
		estados.add("AL");
		estados.add("AP");
		estados.add("AM");
		estados.add("BA");
		estados.add("CE");
		estados.add("DF");
		estados.add("ES");
		estados.add("GO");
		estados.add("MA");
		estados.add("MT");
		estados.add("MS");
		estados.add("MG");
		estados.add("PA");
		estados.add("PB");
		estados.add("PR");
		estados.add("PE");
		estados.add("PI");
		estados.add("RJ");
		estados.add("RN");
		estados.add("RS");
		estados.add("RO");
		estados.add("RR");
		estados.add("SC");
		estados.add("SP");
		estados.add("SE");
		estados.add("TO");
	}
	

	public void preRenderView() {
		if (livro == null) {
			livro = new Livro();
		}
	}

	public List<String> sugerirEstados(String consulta) {
		List<String> estadoSugeridos = new ArrayList<>();
		for (String estado : this.estados) {
			if (estado.toLowerCase().startsWith(consulta.toLowerCase())) {
				estadoSugeridos.add(estado);
			}
		}
		return estadoSugeridos;
	}

	public void iniciarNovoCadastroLivro() {
		this.livro = new Livro();
		livro.setExemplares(new ArrayList<Exemplar>());
	}

	public void salvar() throws DacaServiceException {
		if (this.livro != null) {
			service.update(livro);
			reportarMensagemDeSucesso("Atualizado");
		} else {
			service.save(livro);
			reportarMensagemDeSucesso("Salvo");
		}
		init();
	}

	public void remover() throws DacaServiceException {
		service.delete(livro);
		init();
		reportarMensagemDeSucesso("Removido");
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
