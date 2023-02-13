package poxetofinances.com.example.poxetofinances.model.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import poxetofinances.com.example.poxetofinances.modelEntity.Usuario;

// Query methods

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email); // SpringData automaticamente consegue buscar o campo email gerando um script SQL
	
	Optional<Usuario> findByEmailAndNome(String email, String nome);
	
	boolean existsByEmail (String email);
} 
