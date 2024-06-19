package br.gov.sp.fatec.springboot3lab4.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3lab4.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    public List<Produto> findByNomeContainsIgnoreCaseAndValorLessThan(String nome, BigDecimal valor);
    
}
