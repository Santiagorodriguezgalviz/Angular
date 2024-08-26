package com.sistema.bibioteca.IRepository;

import com.sistema.bibioteca.DTO.LibroDto;
import com.sistema.bibioteca.Entity.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ILibroRepository extends IBaseRepository<Libro, Long> {

    @Query(value = "SELECT l.id, l.titulo, l.autor FROM Libro l", nativeQuery = true)
    List<LibroDto> getListLibros();
}
