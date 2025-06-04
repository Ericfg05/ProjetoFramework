package com.alugaaqui.aluga_aqui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugaaqui.aluga_aqui.model.CarrosModel;
import com.alugaaqui.aluga_aqui.repositories.CarrosRepositories;


@RestController//ela responde por requisições
@CrossOrigin(origins = "http://localhost:3000")
// @CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/carros")// criar uma rota (Endpoints)

public class CarrosController {
    @Autowired //anotação define que essa variavel precisa ser injetada (como se fosse passada por construct)
   

    private CarrosRepositories carros;
    @GetMapping
    public List<CarrosModel> findAll(){
       
       return carros.findAll();

    }
   @DeleteMapping("remover/{id}")
public ResponseEntity<Void> deleteById(@PathVariable long id) {
    if (carros.existsById(id)) {
        carros.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    } else {
        return ResponseEntity.notFound().build(); // 404 Not Found
    }
}
 @PostMapping("/cadastrar")
    public ResponseEntity<CarrosModel> cadastrarCarro(@RequestBody CarrosModel carro) {
        CarrosModel car = carros.save(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<CarrosModel> editarCarro(@PathVariable Long id, @RequestBody CarrosModel carroDetalhes) {
        return carros.findById(id)
            .map(carroExistente -> {
                carroExistente.setModelo_carros(carroDetalhes.getModelo_carros());
                carroExistente.setMarca_carros(carroDetalhes.getMarca_carros());
                carroExistente.setPlaca_carros(carroDetalhes.getPlaca_carros());
                carroExistente.setAno_carros(carroDetalhes.getAno_carros());
                carroExistente.setCor_carros(carroDetalhes.getCor_carros());
                carroExistente.setStatus_carros(carroDetalhes.getStatus_carros());
                carroExistente.setValor_carros(carroDetalhes.getValor_carros());
                carroExistente.setImagens_carros(carroDetalhes.getImagens_carros());
    
                CarrosModel carroAtualizado = carros.save(carroExistente);
                return ResponseEntity.ok(carroAtualizado);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    
}
