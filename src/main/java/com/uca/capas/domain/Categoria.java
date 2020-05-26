package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_categoria")
	private Integer cCategoria;
	
	@Column(name="s_categoria")
	@NotEmpty(message="El campo categoria puede estar vacio")
	@Size(max=500, message="El campo categoria sobrepasa de 50 caracteres")
	private String sCategoria;
	
	@OneToMany(mappedBy="categoria", fetch=FetchType.EAGER)
	private List<Libro> libros;

	public Integer getcCategoria() {
		return cCategoria;
	}

	public void setcCategoria(Integer cCategoria) {
		this.cCategoria = cCategoria;
	}

	public String getsCategoria() {
		return sCategoria;
	}

	public void setsCategoria(String sCategoria) {
		this.sCategoria = sCategoria;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	

}
