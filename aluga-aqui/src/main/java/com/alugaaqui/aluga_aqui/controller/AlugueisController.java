package com.alugaaqui.aluga_aqui.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alugaaqui.aluga_aqui.dto.AluguelRequestDTO;
import com.alugaaqui.aluga_aqui.model.AlugueisModel;
import com.alugaaqui.aluga_aqui.model.CarrosModel;
import com.alugaaqui.aluga_aqui.model.enums.StatusCarro;
import com.alugaaqui.aluga_aqui.repositories.AlugueisRepositories;
import com.alugaaqui.aluga_aqui.repositories.CarrosRepositories;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/alugueis")

public class AlugueisController {

    @Autowired
    private AlugueisRepositories repo;
    @Autowired
    private CarrosRepositories carros;
   @PostMapping("/cada")
public ResponseEntity<?> cadastrar(@RequestBody AluguelRequestDTO dto) {
    Optional<CarrosModel> carroOpt = carros.findById(dto.getIdCarro());

    if (carroOpt.isEmpty()) {
        return ResponseEntity.badRequest().body("Carro não encontrado");
    }

    CarrosModel carro = carroOpt.get();

    // Atualiza o status do carro para INDISPONIVEL
    carro.setStatus_carros(StatusCarro.INDISPONIVEL);
    carros.save(carro); // ← Salva a mudança no banco

    AlugueisModel aluguel = new AlugueisModel();
    aluguel.setDataInicioAlugueis(dto.getDataInicioAlugueis());
    aluguel.setDataFimAlugueis(dto.getDataFimAlugueis());
    aluguel.setObservacoesAlugueis(dto.getObservacoesAlugueis());
    aluguel.setNomeCliente(dto.getNomeCliente());
    aluguel.setEndereco(dto.getEndereco());
    aluguel.setValorTotalAlugueis(dto.getValorTotalAlugueis());
    aluguel.setCarro(carro);

    repo.save(aluguel);

    return ResponseEntity.ok(aluguel);
}
 
 @GetMapping
  public ResponseEntity<List<AlugueisModel>> listarTodosAlugueis() {
    try {
        List<AlugueisModel> alugueis = repo.findAll();
        return ResponseEntity.ok(alugueis);
    } catch (Exception e) {
        return ResponseEntity.status(500).build(); // erro interno do servidor
    }
}


   /* @GetMapping("/{idAluguel}")
    public ResponseEntity<AlugueisModel> buscarAluguelPorId(@PathVariable Integer idAluguel) {
        Optional<AlugueisModel> aluguelOpt = alugueisService.buscarAluguelPorId(idAluguel);
        return aluguelOpt.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    // Processar a devolução de um carro e finalizar o aluguel.
    
    @PutMapping("/{idAluguel}/finalizar")
    public ResponseEntity<AlugueisModel> processarDevolucaoEFinalizarAluguel(@PathVariable Integer idAluguel) {
        AlugueisModel aluguel = alugueisService.processarDevolucaoEFinalizarAluguel(idAluguel);
        return ResponseEntity.ok(aluguel);
    }*/

}