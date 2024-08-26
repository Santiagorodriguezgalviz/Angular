package com.sistema.bibioteca.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro extends ABaseEntity{
	
	@Column(name = "codigo", length = 50, nullable = false)
    private String codigo;
	
	@Column(name = "titulo", length = 50, nullable = false)
	 private String titulo;

	 @Column(name = "autor", length = 50,  nullable = false)
	 private String autor;
	 
	 @Column(name = "ano_publicacion", nullable = false)
	    private int anoPublicacion;
	 
	 @Column(name = "genero", nullable = false)
	    private String genero;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnoPublicacion() {
		return anoPublicacion;
	}

	public void setAnoPublicacion(int anoPublicacion) {
		this.anoPublicacion = anoPublicacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	 

}
