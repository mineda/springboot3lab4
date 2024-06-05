package br.gov.sp.fatec.springboot3lab4.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3lab4.entity.Encomenda;
import br.gov.sp.fatec.springboot3lab4.repository.EncomendaRepository;

@Service
public class EncomendaService {

    @Autowired
    private EncomendaRepository repo;

    public List<Encomenda> todas() {
        return repo.findAll();
    }

    public Encomenda nova(Encomenda encomenda) {
        if(encomenda == null ||
                encomenda.getConteudo() == null ||
                encomenda.getConteudo().isBlank() ||
                encomenda.getDataHoraPrevista() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        
        return repo.save(encomenda);
    }

    public List<Encomenda> buscarPorConteudoOuDataHoraPrevista(String conteudo, LocalDateTime dataHoraPrevista) {
        return repo.buscarPorConteudoOuDataHoraPrevista(conteudo, dataHoraPrevista);
    }
    
}
