package poxetofinances.com.example.poxetofinances.service.impl;


import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import poxetofinances.com.example.poxetofinances.exception.ErroAutenticacaoException;
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
	@Override
	public Optional<Usuario> autenticar(String email, String senha) {
		Optional<Usuario> usuario = repository.findByEmail(email);
		if (!usuario.isPresent()) {
			throw new ErroAutenticacaoException("Email ainda não cadastrado.");
		}
		if (!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacaoException("Senha inválida");
		}
		return usuario; // ou usuario.get() ??? questoes
	}
	
	@Override
	@Transactional
	public Usuario cadastrarUsuario(Usuario usuario) { // salvar usuario

		validarEmail(usuario.getEmail());
		
		return repository.save(usuario);		
		
	}
	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if (existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com esse email");
		}
		
	}

	
}
