package com.ifpb.daca.sidcley.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_Livro", uniqueConstraints = @UniqueConstraint(name = "UC_ISBN", columnNames = { "isbn" }))
public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String isbn;
	private String titulo;
	private String local;
	private String nVolume;
	
	@Temporal(TemporalType.DATE)
	private Date anoPublicacao;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "livro")
	private Collection<Exemplar> exemplares;

	public Livro() {
		super();
		exemplares = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getnVolume() {
		return nVolume;
	}

	public void setnVolume(String nVolume) {
		this.nVolume = nVolume;
	}

	public Date getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Date anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public Collection<Exemplar> getExemplares() {
		return exemplares;
	}

	public void setExemplares(Collection<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoPublicacao == null) ? 0 : anoPublicacao.hashCode());
		result = prime * result + id;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((nVolume == null) ? 0 : nVolume.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Livro other = (Livro) obj;
		if (anoPublicacao == null) {
			if (other.anoPublicacao != null)
				return false;
		} else if (!anoPublicacao.equals(other.anoPublicacao))
			return false;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (nVolume == null) {
			if (other.nVolume != null)
				return false;
		} else if (!nVolume.equals(other.nVolume))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", local=" + local + ", nVolume=" + nVolume
				+ ", anoPublicacao=" + anoPublicacao + "]";
	}
}
