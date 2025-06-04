package com.alugaaqui.aluga_aqui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alugaaqui.aluga_aqui.model.CarrosModel;

public interface CarrosRepositories extends  JpaRepository<CarrosModel, Long>{
    
}
