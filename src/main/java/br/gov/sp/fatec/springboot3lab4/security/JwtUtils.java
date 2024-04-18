package br.gov.sp.fatec.springboot3lab4.security;

import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.IOException;
import io.jsonwebtoken.security.Keys;

public class JwtUtils {

    private static final String KEY = "br.gov.sp.fatec.springbootexample";

    public static String generateToken(Authentication usuario) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Login usuarioSemSenha = new Login();
        usuarioSemSenha.setNome(usuario.getName());
        if (!usuario.getAuthorities().isEmpty()) {
            for(GrantedAuthority auth: usuario.getAuthorities()) {
                usuarioSemSenha.getAutorizacoes().add(auth.getAuthority());
            }
        }
        String usuarioJson = mapper.writeValueAsString(usuarioSemSenha);
        Date agora = new Date();
        Long hora = 1000L * 60L * 60L; // Uma hora
        return Jwts.builder()
                .claim("userDetails", usuarioJson)
                .setIssuer("br.gov.sp.fatec")
                .setSubject(usuario.getName())
                .setExpiration(new Date(agora.getTime() + hora))
                .signWith(Keys.hmacShaKeyFor(KEY.getBytes()), SignatureAlgorithm.HS256).compact();
    }

    public static Authentication parseToken(String token)
            throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String credentialsJson = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(KEY.getBytes())).build()
                .parseClaimsJws(token).getBody().get("userDetails", String.class);
        Login usuario = mapper.readValue(credentialsJson, Login.class);
        UserDetails userDetails = User.builder().username(usuario.getNome()).password("secret")
                .authorities(usuario.getAutorizacoes().toArray(new String[usuario.getAutorizacoes().size()])).build();
        return new UsernamePasswordAuthenticationToken(usuario.getNome(), usuario.getSenha(),
                userDetails.getAuthorities());
    }

}
