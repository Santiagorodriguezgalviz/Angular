package com.sistema.bibioteca.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends ABaseEntity {
    
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "correo", length = 50, nullable = false, unique = true)
    private String correo;
    
    @Column(name = "telefono", length = 50, nullable = false)
    private String telefono;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
    
    
    
}