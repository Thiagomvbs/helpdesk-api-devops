package com.helpdesk.api.controller;

import com.helpdesk.api.model.Usuario;
import com.helpdesk.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario>criar(@RequestBody Usuario usuario){
        return ResponseEntity.ok(service.criar(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>>listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario>listarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.listarPorId(id));
    }
}
