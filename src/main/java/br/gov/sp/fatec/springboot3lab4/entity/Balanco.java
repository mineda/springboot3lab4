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
@Table(name = "bal_balanco")
public class Balanco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bal_id")
    private Long id;

    @Column(name = "bal_desc")
    private String descricao;

    @Column(name = "bal_data_hora")
    private LocalDateTime dataHora;

    @Column(name = "bal_valor_unitario")
    private BigDecimal valorUnitario;

    @Column(name = "bal_quantidade")
    private Integer quantidade;

    public Balanco() {}

        public Balanco(String descricao, LocalDateTime dataHora, BigDecimal valorUnitario, Integer quantidade) {
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
      
}

