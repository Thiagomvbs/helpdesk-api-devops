package com.helpdesk.api.controller;

import com.helpdesk.api.model.Usuario;
import com.helpdesk.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<Usuario>> listar(@PageableDefault(size = 10, sort = "id") Pageable paginacao) {
        Page<Usuario> pagina = service.listar(paginacao);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario>listarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.listarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        return ResponseEntity.ok(service.atualizar(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
