package com.sistema.bibioteca.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.bibioteca.DTO.ReservaDto;
import com.sistema.bibioteca.Entity.Reserva;
import com.sistema.bibioteca.IRepository.IBaseRepository;
import com.sistema.bibioteca.IRepository.IReservaRepository;
import com.sistema.bibioteca.IService.IReservaService;

@Service
public class ReservaService extends ABaseService<Reserva> implements IReservaService {

    @Autowired
    public IReservaRepository repository;

    @Override
    protected IBaseRepository<Reserva, Long> getRepository() {
        return repository;
    }

    @Override
    public List<ReservaDto> getListReservas() {
        return repository.getListReservas();
    }
    
    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }
}

