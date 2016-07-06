package com.ifpb.daca.sidcley.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_Exemplar", uniqueConstraints = {
		@UniqueConstraint(name = "UC_codigoItem", columnNames = { "codigoItem" }) })
public class Exemplar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String codigoItem;
	private String observacoes;
	private Date dataFornecimento;
	private boolean disponivel;
	private boolean reservado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Livro_FK")
	private Livro livro;

	@ManyToOne(fetch = FetchType.EAGER)
	private Fornecedor fornecedor;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "exemplar")
	private Collection<Emprestimo> emprestimosFeitos;

	public Exemplar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Date getDataFornecimento() {
		return dataFornecimento;
	}

	public void setDataFornecimento(Date dataFornecimento) {
		this.dataFornecimento = dataFornecimento;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Collection<Emprestimo> getEmprestimosFeitos() {
		return emprestimosFeitos;
	}

	public void setEmprestimosFeitos(Collection<Emprestimo> emprestimosFeitos) {
		this.emprestimosFeitos = emprestimosFeitos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoItem == null) ? 0 : codigoItem.hashCode());
		result = prime * result + ((dataFornecimento == null) ? 0 : dataFornecimento.hashCode());
		result = prime * result + (disponivel ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + (reservado ? 1231 : 1237);
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
		Exemplar other = (Exemplar) obj;
		if (codigoItem == null) {
			if (other.codigoItem != null)
				return false;
		} else if (!codigoItem.equals(other.codigoItem))
			return false;
		if (dataFornecimento == null) {
			if (other.dataFornecimento != null)
				return false;
		} else if (!dataFornecimento.equals(other.dataFornecimento))
			return false;
		if (disponivel != other.disponivel)
			return false;
		if (id != other.id)
			return false;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (reservado != other.reservado)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Exemplar [id=" + id + ", codigoItem=" + codigoItem + ", observacoes=" + observacoes
				+ ", dataFornecimento=" + dataFornecimento + ", disponivel=" + disponivel + ", reservado=" + reservado
				+ "]";
	}
}
