package com.alugaaqui.aluga_aqui.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alugaaqui.aluga_aqui.model.CarrosModel;
import com.alugaaqui.aluga_aqui.repositories.CarrosRepositories;

@Service
public class CarrosServices {
    public String carros(String nome){
        return nome;
    }
    
    private CarrosRepositories carrosRepositories;

    public Optional<CarrosModel> buscarCarroPorId(Long id_carros) { // Ou o nome que você usa, ex: getCarroById
        return carrosRepositories.findById(id_carros);
    }

    // Optional<CarrosModel> buscarCarroPorId(Integer idCarro);
    // CarrosModel salvarOuAtualizarCarro(CarrosModel carro);
}
