package com.sistema.bibioteca.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.bibioteca.DTO.UsuarioDto;
import com.sistema.bibioteca.Entity.Usuario;
import com.sistema.bibioteca.IRepository.IBaseRepository;
import com.sistema.bibioteca.IRepository.IUsuarioRepository;
import com.sistema.bibioteca.IService.IUsuarioService;

@Service
public class UsuarioService extends ABaseService<Usuario> implements IUsuarioService {

    @Autowired
    public IUsuarioRepository repository;

    @Override
    protected IBaseRepository<Usuario, Long> getRepository() {
        return repository;
    }

    @Override
    public List<UsuarioDto> getListUsuarios() {
        return repository.getListUsuarios();
    }
    
    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }
}
