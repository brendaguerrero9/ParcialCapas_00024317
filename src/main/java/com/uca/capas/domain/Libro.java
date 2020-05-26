package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_libro")
	private Integer cLibro;
	
	@Column(name="s_titulo")
	@NotEmpty(message="El campo titulo puede estar vacio")
	@Size(max=500, message="El campo titulo sobrepasa de 500 caracteres")
	private String sTitulo;
	
	@Column(name="s_autor")
	@NotEmpty(message="El campo autor puede estar vacio")
	@Size(max=500, message="El campo autor sobrepasa de 150 caracteres")
	private String sAutor;
	
	@Transient
	private Integer cCategoria;
	
	@Column(name="f_ingreso")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fIngreso;
	
	@Column(name="b_estado")
	private Boolean estado;
	
	@Column(name="s_isbn")
	@NotEmpty(message="El campo isbn puede estar vacio")
	@Size(max=500, message="El campo isbn sobrepasa de 150 caracteres")
	private String isbn;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;
	
	public Libro() {}

	public Integer getcLibro() {
		return cLibro;
	}

	public void setcLibro(Integer cLibro) {
		this.cLibro = cLibro;
	}

	public String getsTitulo() {
		return sTitulo;
	}

	public void setsTitulo(String sTitulo) {
		this.sTitulo = sTitulo;
	}

	public String getsAutor() {
		return sAutor;
	}

	public void setsAutor(String sAutor) {
		this.sAutor = sAutor;
	}

	public Integer getcCategoria() {
		return cCategoria;
	}

	public void setcCategoria(Integer cCategoria) {
		this.cCategoria = cCategoria;
	}

	public Date getfIngreso() {
		return fIngreso;
	}

	public void setfIngreso(Date fIngreso) {
		this.fIngreso = fIngreso;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
	
}
