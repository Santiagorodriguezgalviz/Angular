package com.sistema.bibioteca.DTO;

import java.sql.Date;

public interface PrestamoDto {
	
	    Long getId();
	    Long getIdUsuario(); // Ejemplo de atributo
	    Long getIdLibro(); // Ejemplo de atributo
	    Date getFechaPrestamo(); // Ejemplo de atributo
	    Date getFechaDevolucion(); // Ejemplo de atributo
	    // Otros métodos para los atributos que deseas exponer en el DTO
}
