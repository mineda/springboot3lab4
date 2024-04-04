package br.gov.sp.fatec.springboot3lab4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3lab4.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Optional<Usuario> getByNome(String nomeUsuario);

    @Query("select u from Usuario u where u.nome = ?1")
    public Optional<Usuario> buscarUsuarioPeloNome(String nomeUsuario);

    public List<Usuario> getByNomeContainsIgnoreCase(String nomeUsuario);

    @Query("select u from Usuario u where u.nome like %?1%")
    public List<Usuario> buscarUsuarioComNomeParecido(String nomeUsuario);

    public Optional<Usuario> getByNomeAndSenha(String nomeUsuario, String senha);

    @Query("select u From Usuario u where u.nome = ?1 and u.senha = ?2")
    public Optional<Usuario> buscarPorNomeESenha(String nomeUsuario, String senha);

    public List<Usuario> getByAutorizacoesNome(String nomeAutorizacao);

    @Query("select u from Usuario u join u.autorizacoes a where a.nome = ?1")
    public List<Usuario> buscarPorNomeAutorizacao(String nomeAutorizacao);

    public Integer countByNomeContains(String nomeUsuario);

    public List<Usuario> getByIdGreaterThanOrderByNome(Long id);

}
