package com.sistema.bibioteca.IRepository;

import com.sistema.bibioteca.DTO.PrestamoDto;
import com.sistema.bibioteca.Entity.Prestamo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IPrestamoRepository extends IBaseRepository<Prestamo, Long> {

    @Query(value = "SELECT p.id, p.id_usuario, p.id_libro, p.fecha_prestamo, p.fecha_devolucion FROM Prestamo p", nativeQuery = true)
    List<PrestamoDto> getListPrestamos();
}
