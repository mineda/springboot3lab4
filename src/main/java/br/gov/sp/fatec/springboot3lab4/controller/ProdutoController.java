package br.gov.sp.fatec.springboot3lab4.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3lab4.entity.Produto;
import br.gov.sp.fatec.springboot3lab4.service.ProdutoService;


@RestController
@RequestMapping(value = "/produto")
@CrossOrigin
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> buscarTodos() {
        return service.todos();
    }

    @PostMapping
    public Produto novo(@RequestBody Produto produto) {
        return service.novo(produto);
    }

    @GetMapping(value = "/{nome}/{valor}")
    public List<Produto> buscarPorNomeEValor(@PathVariable("nome") String nome, @PathVariable("valor") BigDecimal valor) {
        return service.buscarPorNomeEValor(nome, valor);
    }
}
