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

import br.gov.sp.fatec.springboot3lab4.entity.Balanco;
import br.gov.sp.fatec.springboot3lab4.service.BalancoService;

@RestController
@RequestMapping(value = "/balanco")
@CrossOrigin
public class BalancoController {

    @Autowired
    private BalancoService service;

    @GetMapping
    public List<Balanco> buscarTodos() {
        return service.todos();
    }

    @PostMapping
    public Balanco novo(@RequestBody Balanco balanco) {
        return service.novo(balanco);
    }

    @GetMapping(value = "/{descricao}/{valor}")
    public List<Balanco> buscarPorDescricaoEValor(@PathVariable("descricao") String descricao, @PathVariable("valor") BigDecimal valor) {
        return service.buscarPorDescricaoEValor(descricao, valor);
    }
    

}
