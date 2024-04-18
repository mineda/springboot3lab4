package br.gov.sp.fatec.springboot3lab4.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springboot3lab4.entity.Autorizacao;
import br.gov.sp.fatec.springboot3lab4.entity.Usuario;
import br.gov.sp.fatec.springboot3lab4.repository.UsuarioRepository;

@Service
public class SegurancaService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuarioOp = usuarioRepo.getByNome(username);

        if (usuarioOp.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }

        Usuario usuario = usuarioOp.get();
        String autorizacoes[] = new String[usuario.getAutorizacoes().size()];
        Integer i = 0;
        for (Autorizacao aut : usuario.getAutorizacoes()) {
            autorizacoes[i++] = aut.getNome();
        }

        return User.builder().username(usuario.getNome()).password(usuario.getSenha()).authorities(autorizacoes)
                .build();
    }

}
