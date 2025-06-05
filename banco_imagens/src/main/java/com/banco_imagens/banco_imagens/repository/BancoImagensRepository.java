package com.banco_imagens.banco_imagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco_imagens.banco_imagens.model.BancoImagensModel;

@Repository
public interface BancoImagensRepository extends JpaRepository<BancoImagensModel,Long>{}
