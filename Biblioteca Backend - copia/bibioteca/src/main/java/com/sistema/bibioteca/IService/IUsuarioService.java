package com.sistema.bibioteca.IService;

import java.util.List;

import com.sistema.bibioteca.DTO.UsuarioDto;
import com.sistema.bibioteca.Entity.Usuario;

public interface IUsuarioService extends IBaseService<Usuario> {
	
	List<UsuarioDto> getListUsuarios();
}
