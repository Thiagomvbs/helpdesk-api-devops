package com.helpdesk.api.controller;

import com.helpdesk.api.model.Chamado;
import com.helpdesk.api.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {
    @Autowired
    private final ChamadoService service;

    public ChamadoController(ChamadoService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Chamado> criar(@RequestBody Chamado chamado){
        return ResponseEntity.ok(service.criar(chamado));
    }

    @GetMapping
    public ResponseEntity<List<Chamado>> listar(){
        return ResponseEntity.ok(service.listar());
    }
}
