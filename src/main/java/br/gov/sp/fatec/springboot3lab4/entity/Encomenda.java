package br.gov.sp.fatec.springboot3lab4.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enc_encomenda")
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enc_rastreio")
    private Long rastreio;

    @Column(name = "enc_conteudo")
    private String conteudo;

    @Column(name = "enc_valor_declarado")
    private BigDecimal valorDeclarado;

    @Column(name = "enc_data_hora_prevista")
    private LocalDateTime dataHoraPrevista;

    @Column(name = "enc_data_hora_entrega")
    private LocalDateTime dataHoraEntrega;

    public Encomenda() {}

    public Encomenda(String conteudo, LocalDateTime dataHoraPrevista) {
        this.conteudo = conteudo;
        this.dataHoraPrevista = dataHoraPrevista;
    }

    public Long getRastreio() {
        return rastreio;
    }

    public void setRastreio(Long rastreio) {
        this.rastreio = rastreio;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataHoraPrevista() {
        return dataHoraPrevista;
    }

    public void setDataHoraPrevista(LocalDateTime dataHoraPrevista) {
        this.dataHoraPrevista = dataHoraPrevista;
    }

    public LocalDateTime getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public BigDecimal getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(BigDecimal valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

}

