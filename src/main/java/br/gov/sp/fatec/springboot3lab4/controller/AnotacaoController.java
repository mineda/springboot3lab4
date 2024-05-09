package br.gov.sp.fatec.springboot3lab4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springboot3lab4.entity.Anotacao;
import br.gov.sp.fatec.springboot3lab4.entity.Views;
import br.gov.sp.fatec.springboot3lab4.service.AnotacaoService;

@RestController
@RequestMapping(value = "/anotacao")
@CrossOrigin
public class AnotacaoController {

    @Autowired
    private AnotacaoService service;

    @GetMapping
    @JsonView(Views.AnotacaoComUsuario.class)
    public List<Anotacao> buscarTodos() {
        return service.todas();
    }    

}
