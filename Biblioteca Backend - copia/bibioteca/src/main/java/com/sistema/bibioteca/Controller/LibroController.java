package com.sistema.bibioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.bibioteca.DTO.ApiResponseDto;
import com.sistema.bibioteca.DTO.LibroDto;
import com.sistema.bibioteca.Entity.Libro;
import com.sistema.bibioteca.IService.ILibroService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/libro")
public class LibroController extends ABaseController<Libro, ILibroService> {
    public LibroController(ILibroService service) {
        super(service, "Libro");
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<LibroDto>>> show() {
        try {
            List<LibroDto> entity = service.getListLibros();
            return ResponseEntity.ok(new ApiResponseDto<>("Registros encontrados", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }
}
