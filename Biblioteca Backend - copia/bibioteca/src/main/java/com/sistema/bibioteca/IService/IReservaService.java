package com.sistema.bibioteca.IService;

import java.util.List;

import com.sistema.bibioteca.DTO.ReservaDto;
import com.sistema.bibioteca.Entity.Reserva;

public interface IReservaService extends IBaseService<Reserva> {
	
	List<ReservaDto> getListReservas();
}
