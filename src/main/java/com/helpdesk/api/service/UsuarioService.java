package com.helpdesk.api.service;

import com.helpdesk.api.exception.ResourceNotFoundException;
import com.helpdesk.api.model.Usuario;
import com.helpdesk.api.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
    @Autowired
    private final UsuarioRepository repository;

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Usuario criar(Usuario usuario){
        log.info("Criando usuario: Nome={} e email={}", usuario.getNome(), usuario.getEmail());

        if (repository.existsByEmail(usuario.getEmail())) {
            log.warn("Tentativa de cadastro com e-mail já existente: {}", usuario.getEmail());
            throw new RuntimeException("E-mail já cadastrado no sistema.");
        }

        try{
            Usuario usuarioSalvo = repository.save(usuario);
            log.info("Usuário criado com sucesso! ID={}", usuarioSalvo.getId());
            return usuarioSalvo;
        } catch (Exception e) {
            log.error("Erro ao criar usuário: {}",usuario.getEmail() ,e);
            throw e;
        }

    }

    public Page<Usuario> listar(Pageable paginacao) {
        log.info("Listando usuários com paginação");
        return repository.findAll(paginacao);
    }

    public Usuario listarPorId(Long id){
        log.info("Listando usuario por ID={}", id);

        return repository.findById(id)
                .map(usuario -> {
                    log.info("Usuário encontrado: {}", usuario.getEmail());
                    return usuario;
                })
                .orElseThrow(() -> {
                    log.warn("Usuário não encontrado para o ID: {}", id);
                    return new ResourceNotFoundException("Usuário não encontrado com ID=" + id);
                });
    }

    @Transactional
    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        log.info("Atualizando usuário ID={}", id);

        return repository.findById(id)
                .map(usuario -> {
                    if (!usuario.getEmail().equals(usuarioAtualizado.getEmail()) &&
                            repository.existsByEmail(usuarioAtualizado.getEmail())) {
                        throw new RuntimeException("Este novo e-mail já está em uso.");
                    }
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    log.info("Usuário ID={} atualizado com sucesso", id);
                    return repository.save(usuario);
                })
                .orElseThrow(() -> {
                    log.warn("Falha na atualização: ID={} não existe", id);
                    return new ResourceNotFoundException("Usuário não encontrado com ID=" + id);
                });
    }

    @Transactional
    public void deletar(Long id){
        log.info("Deletando usuário ID={}", id);

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Falha na exclusão: ID={} não existe", id);
                    return new ResourceNotFoundException("Usuário não encontrado com ID=" + id);
                });
        repository.delete(usuario);
        log.info("Usuário ID={} deletado com sucesso", id);
    }
}
