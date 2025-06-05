package com.banco_imagens.banco_imagens.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco_imagens.banco_imagens.model.BancoImagensModel;
import com.banco_imagens.banco_imagens.repository.BancoImagensRepository;

@Service
public class BancoImagensService {
    @Autowired
    private BancoImagensRepository repository;
    public List<BancoImagensModel> listarTodos(){
        return repository.findAll();
    }

    public Optional<BancoImagensModel> buscarId(Long id){
        return repository.findById(id);
    }
    
    public BancoImagensModel salvar(BancoImagensModel bancoImagensModel){
        return repository.save(bancoImagensModel);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
