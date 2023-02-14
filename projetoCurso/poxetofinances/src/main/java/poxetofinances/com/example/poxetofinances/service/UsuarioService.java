package poxetofinances.com.example.poxetofinances.service;

import java.util.Optional;

import poxetofinances.com.example.poxetofinances.modelEntity.Usuario;

public interface UsuarioService {

	Optional<Usuario> autenticar(String email, String senha);
	
	Usuario cadastrarUsuario(Usuario usuario);
	
	void validarEmail(String email);
	
	
}
