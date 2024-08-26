package com.sistema.bibioteca.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.bibioteca.DTO.PrestamoDto;
import com.sistema.bibioteca.Entity.Prestamo;
import com.sistema.bibioteca.IRepository.IBaseRepository;
import com.sistema.bibioteca.IRepository.IPrestamoRepository;
import com.sistema.bibioteca.IService.IPrestamoService;

@Service
public class PrestamoService extends ABaseService<Prestamo> implements IPrestamoService{

	@Override
	public List<PrestamoDto> getListPrestamos() {
		// TODO Auto-generated method stub
		return repository.getListPrestamos();
	}

	@Override
	protected IBaseRepository<Prestamo, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	private IPrestamoRepository repository;

}
