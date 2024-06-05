package br.gov.sp.fatec.springboot3lab4.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3lab4.entity.Balanco;

public interface BalancoRepository extends JpaRepository<Balanco, Long>{

    @Query("select b from Balanco b where b.descricao like %?1% and (b.valorUnitario * b.quantidade) <= ?2")
    public List<Balanco> buscarPorDescricaoOuValorTotal(String descricao, BigDecimal valor);
    
}
