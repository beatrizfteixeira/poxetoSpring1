package poxetofinances.com.example.poxetofinances.service;

import poxetofinances.com.example.poxetofinances.modelEntity.Usuario;

public interface UsuarioService {

	Usuario autenticar(String email, String senha);
	
	Usuario cadastrarUsuario(Usuario usuario);
	
	void validarEmail(String email);
	
	
}
