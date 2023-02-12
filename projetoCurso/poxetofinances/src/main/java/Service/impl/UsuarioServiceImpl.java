package Service.impl;

import org.springframework.stereotype.Service;

import Service.UsuarioService;
import exception.RegraNegocioException;
import model.Repository.UsuarioRepository;
import poxetofinances.com.example.poxetofinances.modelEntity.Usuario;


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
