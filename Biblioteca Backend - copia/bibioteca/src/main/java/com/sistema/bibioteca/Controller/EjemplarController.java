package com.sistema.bibioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistema.bibioteca.DTO.ApiResponseDto;
import com.sistema.bibioteca.DTO.EjemplarDto;
import com.sistema.bibioteca.Entity.Ejemplar;
import com.sistema.bibioteca.IService.IEjemplarService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/ejemplar")
public class EjemplarController extends ABaseController<Ejemplar, IEjemplarService> {

    public EjemplarController(IEjemplarService service) {
        super(service, "Ejemplar");
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<EjemplarDto>>> show() {
        try {
            List<EjemplarDto> entity = service.getListEjemplares();
            return ResponseEntity.ok(new ApiResponseDto<List<EjemplarDto>>("Registros encontrados", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }
}
