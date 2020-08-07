package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.Usuario;

@Service
public class UsuarioService {

    @Value("${backend.base-uri}")
    private String baseUri;
    
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    
    public Usuario buscarUsuarios() {
        
        RestTemplate restTemplate = restTemplateBuilder.build();
        
        String url = String.format("%s/usuarios", baseUri);
        
        Usuario usuario = restTemplate.getForEntity(url, Usuario.class).getBody();
        
        return usuario;
    }
    
}
