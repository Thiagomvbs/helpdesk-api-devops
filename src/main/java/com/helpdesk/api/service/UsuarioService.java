package com.helpdesk.api.service;

import com.helpdesk.api.exception.ResourceNotFoundException;
import com.helpdesk.api.model.Usuario;
import com.helpdesk.api.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private final UsuarioRepository repository;

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario criar(Usuario usuario){
        log.info("Criando usuario: Nome={} e email={}", usuario.getNome(), usuario.getEmail());
        return repository.save(usuario);
    }

    public List<Usuario> listar(){
        log.info("Listando usuarios");
        return repository.findAll();
    }

    public Usuario listarPorId(Long id){
        log.info("Listando usuario por ID={}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado com ID=" + id));
    }
}
