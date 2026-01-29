package com.helpdesk.api.service;

import com.helpdesk.api.model.Chamado;
import com.helpdesk.api.repository.ChamadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {
    @Autowired
    private final ChamadoRepository repository;

    private static final Logger log = LoggerFactory.getLogger(ChamadoService.class);

    public ChamadoService(ChamadoRepository repository) {
        this.repository = repository;
    }

    public Chamado criar(Chamado chamado){
        log.info("Criando chamado: titulo={}", chamado.getTitulo());
        return repository.save(chamado);
    }

    public List<Chamado> listar(){
        log.info("Listando chamados");
        return repository.findAll();
    }


}
