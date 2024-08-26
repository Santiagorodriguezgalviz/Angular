package com.sistema.bibioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistema.bibioteca.DTO.ApiResponseDto;
import com.sistema.bibioteca.DTO.UsuarioDto;
import com.sistema.bibioteca.Entity.Usuario;
import com.sistema.bibioteca.IService.IUsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/usuario")
public class UsuarioController extends ABaseController<Usuario, IUsuarioService> {

    public UsuarioController(IUsuarioService service) {
        super(service, "Usuario");
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<UsuarioDto>>> show() {
        try {
            List<UsuarioDto> entity = service.getListUsuarios();
            return ResponseEntity.ok(new ApiResponseDto<>("Registros encontrados", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
        }
    }
}
