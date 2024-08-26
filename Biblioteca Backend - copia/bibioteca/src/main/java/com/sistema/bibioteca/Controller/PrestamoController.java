package com.sistema.bibioteca.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistema.bibioteca.DTO.ApiResponseDto;
import com.sistema.bibioteca.DTO.PrestamoDto;
import com.sistema.bibioteca.Entity.Prestamo;
import com.sistema.bibioteca.IService.IPrestamoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/prestamo")
public class PrestamoController extends ABaseController<Prestamo, IPrestamoService> {
    public PrestamoController(IPrestamoService service) {
        super(service, "Prestamo");
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<PrestamoDto>>> show() {
        try {
            List<PrestamoDto> entity = service.getListPrestamos();
            return ResponseEntity.ok(new ApiResponseDto<>("Registros encontrados", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }
}
