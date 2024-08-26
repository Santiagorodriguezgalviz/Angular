package com.sistema.bibioteca.IService;

import java.util.List;

import com.sistema.bibioteca.DTO.PrestamoDto;
import com.sistema.bibioteca.Entity.Prestamo;

public interface IPrestamoService extends IBaseService<Prestamo> {
	
	List<PrestamoDto> getListPrestamos();
}
