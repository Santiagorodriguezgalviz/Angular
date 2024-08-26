package com.sistema.bibioteca.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.bibioteca.DTO.LibroDto;
import com.sistema.bibioteca.Entity.Libro;
import com.sistema.bibioteca.IRepository.IBaseRepository;
import com.sistema.bibioteca.IRepository.ILibroRepository;
import com.sistema.bibioteca.IService.ILibroService;

@Service
public class LibroService extends ABaseService<Libro> implements ILibroService {

    @Autowired
    public ILibroRepository repository;

    @Override
    protected IBaseRepository<Libro, Long> getRepository() {
        return repository;
    }

    @Override
    public List<LibroDto> getListLibros() {
        return repository.getListLibros();
    }
    
    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }
}
