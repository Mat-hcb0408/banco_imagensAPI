package com.banco_imagens.banco_imagens.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "banco_imagens")
@Getter
@Setter
@NoArgsConstructor

public class BancoImagensModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(nullable = false)
private String nome;
@Column(nullable = false)
private String url;
}
