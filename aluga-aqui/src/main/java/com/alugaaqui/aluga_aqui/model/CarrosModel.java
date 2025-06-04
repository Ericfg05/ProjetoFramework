package com.alugaaqui.aluga_aqui.model;

import java.math.BigDecimal;

import com.alugaaqui.aluga_aqui.model.enums.StatusCarro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "carros")
@Getter//metodo getter
@Setter//metodo setter
@AllArgsConstructor //cria o metodo construtor
public class CarrosModel {

    public CarrosModel(){
        
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_carros;

    private String modelo_carros;
    private String marca_carros;
    private String placa_carros;
    private String ano_carros;
    private String cor_carros;
    // private String status_carros;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_carros", length = 20)
    private StatusCarro status_carros;


    private double valor_carros;
    private String imagens_carros;
}
