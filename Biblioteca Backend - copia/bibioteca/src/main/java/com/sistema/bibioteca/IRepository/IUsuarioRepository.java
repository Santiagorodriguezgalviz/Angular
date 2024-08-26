package com.sistema.bibioteca.IRepository;

import com.sistema.bibioteca.DTO.UsuarioDto;
import com.sistema.bibioteca.Entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IUsuarioRepository extends IBaseRepository<Usuario, Long> {

    @Query(value = "SELECT u.id, u.nombre, u.email, u.telefono FROM Usuario u", nativeQuery = true)
    List<UsuarioDto> getListUsuarios();
}
