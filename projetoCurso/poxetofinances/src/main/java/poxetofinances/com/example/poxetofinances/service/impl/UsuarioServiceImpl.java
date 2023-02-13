package poxetofinances.com.example.poxetofinances.service.impl;

import org.springframework.stereotype.Service;

import poxetofinances.com.example.poxetofinances.exception.RegraNegocioException;
import poxetofinances.com.example.poxetofinances.model.Repository.UsuarioRepository;
import poxetofinances.com.example.poxetofinances.modelEntity.Usuario;
import poxetofinances.com.example.poxetofinances.service.UsuarioService;


@Service 
public class UsuarioServiceImpl implements UsuarioService{
	
	
	private UsuarioRepository repository;
	
	public UsuarioServiceImpl (UsuarioRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Usuario autenticar(String email, String senha) {
		
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario cadastrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if (existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com esse email");
		}
		
	}

	
}
