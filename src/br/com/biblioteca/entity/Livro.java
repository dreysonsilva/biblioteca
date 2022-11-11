package br.com.biblioteca.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

@Entity // a classe livro agora é uma entidade
@Table (name = "LIVRO") // nome da tabela
@DynamicUpdate
public class Livro {
	
	@Id //Primary Key
	@GeneratedValue (strategy = GenerationType.SEQUENCE) //Gerar uma estratefia de inserção de valores
	
	@Column (name = "ID_LIVRO", nullable = false) //Nome da Coluna e NULLABLE dizer tb que a coluna não recebe nulo
	private int id;
	
	@Column (name = "AUTOR", nullable = false) //Nome da Coluna e dizer tb que a coluna não recebe nulos
	private String autor;
	
	@Column (name = "TITULO", nullable = false) //Nome da Coluna e dizer tb que a coluna não recebe nulo
	private String titulo;
	
	@Temporal (TemporalType.DATE) //Anotações do Hibernet para tratar data, somente a data
	@Column (name = "DATA_PUBLICACAO", nullable = false) //Nome da Coluna e dizer tb que a coluna pode receber nulo
	private Calendar dataPublicacao;
	
	public Livro() {
	}

	public Livro(String autor, String titulo, Calendar dataPublicacao) {
		this.autor = autor;
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}

	public void setData_publicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
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
		Livro other = (Livro) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Biblioteca [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", dataPublicacao=" + sdf.format(dataPublicacao.getTime())
				+ "]";
	}

	
}