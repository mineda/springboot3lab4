package br.gov.sp.fatec.springboot3lab4.security;

import java.util.ArrayList;
import java.util.List;

public class Login {

    private String nome;

    private String senha;

    private List<String> autorizacoes;

    private String token;

    public Login() {
        setAutorizacoes(new ArrayList<String>());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(List<String> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }
    
    
}
