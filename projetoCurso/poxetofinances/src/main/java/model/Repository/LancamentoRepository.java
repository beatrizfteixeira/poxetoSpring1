package model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poxetofinances.com.example.poxetofinances.modelEntity.Lancamento;


public interface LancamentoRepository extends JpaRepository <Lancamento, Long>{

}
