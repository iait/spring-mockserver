package com.example.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Usuario;
import com.example.service.UsuarioService;

@RestController
@RequestMapping(path = "usuarios")
public class UsuarioCtrl {
    
    @Autowired private UsuarioService usuarioService;
    
    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarios() {
        
        Usuario usuario = usuarioService.buscarUsuarios();
        
        return ResponseEntity.ok(usuario);
    }

}
