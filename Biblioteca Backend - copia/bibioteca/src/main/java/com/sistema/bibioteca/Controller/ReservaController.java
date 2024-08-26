package com.sistema.bibioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistema.bibioteca.DTO.ApiResponseDto;
import com.sistema.bibioteca.DTO.ReservaDto;
import com.sistema.bibioteca.Entity.Reserva;
import com.sistema.bibioteca.IService.IReservaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/reserva")
public class ReservaController extends ABaseController<Reserva, IReservaService> {

    public ReservaController(IReservaService service) {
        super(service, "Reserva");
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<ReservaDto>>> show() {
        try {
            List<ReservaDto> entity = service.getListReservas();
            return ResponseEntity.ok(new ApiResponseDto<>("Registros encontrados", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }
}
