package com.alugaaqui.aluga_aqui.service;

import org.springframework.stereotype.Service;

@Service
public class AlugueisService {

  /*  @Autowired
    private AlugueisRepositories alugueisRepositories;

    @Autowired
    private CarrosServices carrosService;
    @Transactional
    public AlugueisModel registrarAluguel(Long id_carro,
                                      LocalDate dataInicioAlugueis,
                                      LocalDate dataFimAlugueis,
                                      String observacoesAlugueis,
                                      String nomeCliente,
                                      String endereco) {
    if (dataInicioAlugueis == null || dataFimAlugueis == null) {
        throw new IllegalArgumentException("As datas de início e fim do aluguel são obrigatórias.");
    }
    if (dataFimAlugueis.isBefore(dataInicioAlugueis)) {
        throw new IllegalArgumentException("A data de fim do aluguel não pode ser anterior à data de início.");
    }

    CarrosModel carro = carrosService.buscarCarroPorId(id_carro)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado com ID: " + id_carro));




    List<AlugueisModel> alugueisExistentesParaCarro = alugueisRepositories.findByCarro(carro);
    for (AlugueisModel aluguelExistente : alugueisExistentesParaCarro) {
        boolean conflito = !(dataFimAlugueis.isBefore(aluguelExistente.getDataInicioAlugueis()) ||
                                dataInicioAlugueis.isAfter(aluguelExistente.getDataFimAlugueis()));
        if (conflito) {
            throw new IllegalArgumentException("O carro já possui um aluguel registrado que conflita com o período solicitado ("+
                                                aluguelExistente.getDataInicioAlugueis() + " a " + aluguelExistente.getDataFimAlugueis() +").");
        }
    }
                                

    AlugueisModel novoAluguel = new AlugueisModel();
    novoAluguel.setCarro(carro);
    novoAluguel.setDataInicioAlugueis(dataInicioAlugueis);
    novoAluguel.setDataFimAlugueis(dataFimAlugueis);
    novoAluguel.setObservacoesAlugueis(observacoesAlugueis);
    novoAluguel.setNomeCliente(nomeCliente); // ← setando nome
    novoAluguel.setEndereco(endereco);       // ← setando endereço

    // ... cálculo do valor e salvamento como já está

    return alugueisRepositories.save(novoAluguel);
}


    public List<AlugueisModel> listarTodosAlugueis() {
        return alugueisRepositories.findAll();
    }

    public Optional<AlugueisModel> buscarAluguelPorId(Integer idAluguel) {
        return alugueisRepositories.findById(idAluguel);
    }

 
    public AlugueisModel processarDevolucaoEFinalizarAluguel(Integer idAluguel) {
        AlugueisModel aluguel = alugueisRepositories.findById(idAluguel)
            .orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado com ID: " + idAluguel));

        CarrosModel carroDoAluguel = aluguel.getCarro();
        if (carroDoAluguel == null) {
            throw new IllegalStateException("Aluguel ID " + idAluguel + " não está associado a um carro válido, não é possível processar devolução.");
        }

       

        return aluguel;
    }*/
}