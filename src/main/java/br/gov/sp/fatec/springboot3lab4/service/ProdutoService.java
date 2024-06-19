package br.gov.sp.fatec.springboot3lab4.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3lab4.entity.Produto;
import br.gov.sp.fatec.springboot3lab4.repository.ProdutoRepository;

@Service
public class ProdutoService {
   
    
    @Autowired
    private ProdutoRepository repo;

    public List<Produto> todos() {
        return repo.findAll();
    }

    public Produto novo(Produto produto) {
        if(produto == null ||
                produto.getNome() == null ||
                produto.getNome().isBlank() ||
                produto.getValor() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        if(produto.getDataHora() == null) {
            produto.setDataHora(LocalDateTime.now());
        }
        
        return repo.save(produto);
    }

    public List<Produto> buscarPorNomeEValor(String nome, BigDecimal valor) {
        return repo.findByNomeContainsIgnoreCaseAndValorLessThan(nome, valor);
    }
}
