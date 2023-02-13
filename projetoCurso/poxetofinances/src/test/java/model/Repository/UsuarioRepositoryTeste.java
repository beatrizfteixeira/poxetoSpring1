package model.Repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import poxetofinances.com.example.poxetofinances.PoxetofinancesApplication;
import poxetofinances.com.example.poxetofinances.model.Repository.UsuarioRepository;
import poxetofinances.com.example.poxetofinances.modelEntity.Usuario;

@ContextConfiguration(classes = PoxetofinancesApplication.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTeste {
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void verificaExistenciaEmail() {
		// cenario 
		Usuario usuario = Usuario.builder().nome("bia").email("bia@email.com").build();
		repository.save(usuario);
		//acao/execução
		boolean resultado = repository.existsByEmail("bia@email.com");
		//verificacao
		Assertions.assertThat(resultado).isTrue();
	}
	@Test
	public void RetornaFalsoNaoExistemUsuariosNoBD() {
		// cenario 
		repository.deleteAll();
		//acao/execução
		boolean resultado = repository.existsByEmail("bia@email.com");
		//verificacao
		Assertions.assertThat(resultado).isFalse();
	}
}
