package com.sistema.bibioteca.IService;

import java.util.List;


import com.sistema.bibioteca.DTO.LibroDto;
import com.sistema.bibioteca.Entity.Libro;

public interface ILibroService extends IBaseService<Libro> {
	
	List<LibroDto> getListLibros();
}
