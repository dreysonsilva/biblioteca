package br.com.biblioteca.entity;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="Autor")
@DynamicUpdate
public class Autor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nome_autor", nullable=false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nasc, nullable=false")
	private Calendar datanascimento;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=Livro.class, mappedBy="autor")
	private List<Livro> livros;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Calendar getDatanascimento() {
		return datanascimento;
	}
	
	public Autor(){}

	public Autor(int id, String nome, Calendar datanascimento) {
		this.id = id;
		this.nome = nome;
		this.datanascimento = datanascimento;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDatanascimento(Calendar datanascimento) {
		this.datanascimento = datanascimento;
	}


	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return id == other.id;
	}
}