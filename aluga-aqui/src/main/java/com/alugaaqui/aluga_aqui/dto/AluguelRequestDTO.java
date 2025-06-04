package com.alugaaqui.aluga_aqui.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AluguelRequestDTO {

 
    private Long idCarro;

    private LocalDate dataInicioAlugueis;
    private LocalDate dataFimAlugueis;
    private String observacoesAlugueis;
    private String nomeCliente;
    private String endereco;
    private double valorTotalAlugueis; // ← adicionar isso
}