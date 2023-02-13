package model.Repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import poxetofinances.com.example.poxetofinances.PoxetofinancesApplication;
import poxetofinances.com.example.poxetofinances.model.Repository.UsuarioRepository;
import poxetofinances.com.example.poxetofinances.modelEntity.Usuario;

@ContextConfiguration(classes = PoxetofinancesApplication.class)
@RunWith(SpringRunner.class)
@SpringBootTest
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
}
