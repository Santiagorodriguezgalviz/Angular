package com.sistema.bibioteca.IRepository;

import com.sistema.bibioteca.DTO.ReservaDto;
import com.sistema.bibioteca.Entity.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IReservaRepository extends IBaseRepository<Reserva, Long> {

    @Query(value = "SELECT r.id, r.id_usuario, r.id_libro FROM Reserva r", nativeQuery = true)
    List<ReservaDto> getListReservas();
}
