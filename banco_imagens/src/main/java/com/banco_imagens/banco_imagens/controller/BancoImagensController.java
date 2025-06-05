package com.banco_imagens.banco_imagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco_imagens.banco_imagens.model.BancoImagensModel;
import com.banco_imagens.banco_imagens.service.BancoImagensService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins="http://127.0.0.1:5500")
@RestController
@RequestMapping("/bancoImagens")
public class BancoImagensController {
    @Autowired
    private BancoImagensService service;

    @GetMapping
    public List<BancoImagensModel> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancoImagensModel> buscarId(@PathVariable Long id){
        return service.buscarId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
     @PostMapping
     public BancoImagensModel salvar(@RequestBody BancoImagensModel bancoImagensModel){
        return service.salvar(bancoImagensModel);
     }
    
     @PutMapping("/{id}")
     public ResponseEntity<BancoImagensModel>atualizar(@PathVariable Long id, @RequestBody BancoImagensModel bancoImagensModel){
        if (!service.buscarId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        bancoImagensModel.setId(id);
        return ResponseEntity.ok(service.salvar(bancoImagensModel));
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Void>deletar(@PathVariable Long id){
        if (!service.buscarId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
     }
}
