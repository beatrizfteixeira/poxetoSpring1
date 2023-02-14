package model.Repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import poxetofinances.com.example.poxetofinances.PoxetofinancesApplication;
import poxetofinances.com.example.poxetofinances.model.Repository.UsuarioRepository;
import poxetofinances.com.example.poxetofinances.modelEntity.Usuario;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PoxetofinancesApplication.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTeste {

	@Autowired
	UsuarioRepository repository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	public void verificaExistenciaEmail() {
		// cenario
		Usuario usuario = Usuario.builder().nome("bia").email("bia@email.com").build();
		// repository.save(usuario);

		entityManager.persist(usuario);
		// acao/execução
		boolean resultado = repository.existsByEmail("bia@email.com");
		// verificacao
		Assertions.assertThat(resultado).isTrue();
	}

	@Test
	public void RetornaFalsoNaoExistemUsuariosNoBD() {
		// cenario

		// acao/execução
		boolean resultado = repository.existsByEmail("bia@email.com");

		// verificacao
		Assertions.assertThat(resultado).isFalse();
	}

	@Test
	public void buscaUsuarioPorEmail() {
		// cenario
		Usuario usuario = Usuario.builder().nome("jorgete").email("jorgete@email.com").senha("senha").build();
		
		// acao 
		entityManager.persist(usuario);
		
		Optional<Usuario> result = repository.findByEmail("jorgete@email.com");
		
		Assertions.assertThat(result.isPresent()).isTrue();
	}
	
	@Test
	public void deveRetornarVazioQuandoEmailNaoExisteNaBase() {

		Optional<Usuario> result = repository.findByEmail("jorgete@email.com");
		
		Assertions.assertThat(result.isPresent()).isFalse();
	}

	@Test
	public void persistirOUsuarioNoBd() {
		// cenario
		Usuario usuario = Usuario.builder().nome("jorgete").email("jorgete@email.com").senha("senha").build();
		// acao
		Usuario usuarioSalvo = repository.save(usuario);

		// verificação
		Assertions.assertThat(usuarioSalvo.getId()).isNotNull();

	}

}
