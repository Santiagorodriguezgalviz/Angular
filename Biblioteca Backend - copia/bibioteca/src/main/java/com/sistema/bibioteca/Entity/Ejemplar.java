package com.sistema.bibioteca.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ejemplar")
public class Ejemplar extends ABaseEntity {
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "libro_id", nullable = false)
	private Libro libro;
	 
	 
	 @Column(name = "estado", length = 50, nullable = false)
		private String estado;


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	 
	 

}
