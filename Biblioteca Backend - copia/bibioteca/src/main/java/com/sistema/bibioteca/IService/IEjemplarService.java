package com.sistema.bibioteca.IService;

import java.util.List;

import com.sistema.bibioteca.DTO.EjemplarDto;
import com.sistema.bibioteca.Entity.Ejemplar;

public interface IEjemplarService extends IBaseService<Ejemplar> {
	
	List<EjemplarDto> getListEjemplares();
}
