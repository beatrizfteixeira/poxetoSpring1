package poxetofinances.com.example.poxetofinances.service;

//import org.junit.Test.None;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import poxetofinances.com.example.poxetofinances.exception.RegraNegocioException;
import poxetofinances.com.example.poxetofinances.model.Repository.UsuarioRepository;
import poxetofinances.com.example.poxetofinances.modelEntity.Usuario;


// RODAR TESTES COM JUNIT 4!!!

/*
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
*/


public class UsuarioServiceTest {

	@Autowired
	UsuarioService service;

	@Autowired
	UsuarioRepository repository;

	@Test (expected = Test.None.class)
	public void deveValidarEmail() {
		repository.deleteAll();

		service.validarEmail("email@email.com");

	}

	@Test (expected = RegraNegocioException.class)
	public void deveLancarErroQuandoJaExistirEmailCadastrado() {
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
		repository.save(usuario);

		service.validarEmail("usuario@email.com");
	}

}

