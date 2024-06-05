package br.gov.sp.fatec.springboot3lab4.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3lab4.entity.Encomenda;

public interface EncomendaRepository extends JpaRepository<Encomenda, Long>{

    @Query("select e from Encomenda e where e.conteudo like %?1% or e.dataHoraPrevista >= ?2")
    public List<Encomenda> buscarPorConteudoOuDataHoraPrevista(String conteudo, LocalDateTime dataHoraPrevista);
    
}
