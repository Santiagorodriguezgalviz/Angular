package com.sistema.bibioteca.IRepository;

import com.sistema.bibioteca.DTO.EjemplarDto;
import com.sistema.bibioteca.Entity.Ejemplar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IEjemplarRepository extends IBaseRepository<Ejemplar, Long> {

    @Query(value = "SELECT e.id, e.id_libro, e.ubicacion FROM Ejemplar e", nativeQuery = true)
    List<EjemplarDto> getListEjemplares();
}
