package com.ifpb.daca.sidcley.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Emprestimo")
public class Emprestimo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private  Date dataEmprestimo;
	private  Date dataPrevistaDevolucao;
	private  Date dataDevolucao;
	private String observacoesDoEmprstimo;
	private String observacoesDaDevolicao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Pessoa pessoa;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Livro_FK")
	private Exemplar exemplar;

	public Emprestimo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getObservacoesDoEmprstimo() {
		return observacoesDoEmprstimo;
	}

	public void setObservacoesDoEmprstimo(String observacoesDoEmprstimo) {
		this.observacoesDoEmprstimo = observacoesDoEmprstimo;
	}

	public String getObservacoesDaDevolicao() {
		return observacoesDaDevolicao;
	}

	public void setObservacoesDaDevolicao(String observacoesDaDevolicao) {
		this.observacoesDaDevolicao = observacoesDaDevolicao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Exemplar getLivro() {
		return exemplar;
	}

	public void setLivro(Exemplar livro) {
		this.exemplar = livro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDevolucao == null) ? 0 : dataDevolucao.hashCode());
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((dataPrevistaDevolucao == null) ? 0 : dataPrevistaDevolucao.hashCode());
		result = prime * result + id;
		result = prime * result + ((observacoesDaDevolicao == null) ? 0 : observacoesDaDevolicao.hashCode());
		result = prime * result + ((observacoesDoEmprstimo == null) ? 0 : observacoesDoEmprstimo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (dataDevolucao == null) {
			if (other.dataDevolucao != null)
				return false;
		} else if (!dataDevolucao.equals(other.dataDevolucao))
			return false;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (dataPrevistaDevolucao == null) {
			if (other.dataPrevistaDevolucao != null)
				return false;
		} else if (!dataPrevistaDevolucao.equals(other.dataPrevistaDevolucao))
			return false;
		if (id != other.id)
			return false;
		if (observacoesDaDevolicao == null) {
			if (other.observacoesDaDevolicao != null)
				return false;
		} else if (!observacoesDaDevolicao.equals(other.observacoesDaDevolicao))
			return false;
		if (observacoesDoEmprstimo == null) {
			if (other.observacoesDoEmprstimo != null)
				return false;
		} else if (!observacoesDoEmprstimo.equals(other.observacoesDoEmprstimo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", dataEmprestimo=" + dataEmprestimo + ", dataPrevistaDevolucao="
				+ dataPrevistaDevolucao + ", dataDevolucao=" + dataDevolucao + ", observacoesDoEmprstimo="
				+ observacoesDoEmprstimo + ", observacoesDaDevolicao=" + observacoesDaDevolicao + "]";
	}
}
