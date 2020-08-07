package com.example.ctrl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "saludo")
public class EjemploCtrl {

    @GetMapping
    public ResponseEntity<String> ejemplo() {
        return ResponseEntity.ok("Hola Mundo!");
    }
}
