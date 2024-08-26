package com.sistema.bibioteca.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.bibioteca.DTO.EjemplarDto;
import com.sistema.bibioteca.Entity.Ejemplar;
import com.sistema.bibioteca.IRepository.IBaseRepository;
import com.sistema.bibioteca.IRepository.IEjemplarRepository;
import com.sistema.bibioteca.IService.IEjemplarService;

@Service
public class EjemplarService extends ABaseService<Ejemplar> implements IEjemplarService {

   
    @Autowired
    private IEjemplarRepository repository;

    @Override
    public List<EjemplarDto> getListEjemplares() {
        return repository.getListEjemplares();
    }
    
    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }

	@Override
	protected IBaseRepository<Ejemplar, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	
	
}

