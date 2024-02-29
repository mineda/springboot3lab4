package br.gov.sp.fatec.springboot3lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3lab4.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
