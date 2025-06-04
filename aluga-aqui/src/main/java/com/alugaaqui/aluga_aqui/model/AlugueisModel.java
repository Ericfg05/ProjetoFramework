package com.alugaaqui.aluga_aqui.model;

// import com.alugaaqui.aluga_aqui.model.enums.StatusAluguel;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@Entity
@Table(name = "alugueis") 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlugueisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alugueis")
    private Integer idAlugueis; 

    @Column(name = "data_inicio_alugueis")
    private LocalDate dataInicioAlugueis;

    @Column(name = "data_fim_alugueis")
    private LocalDate dataFimAlugueis; 

    @Column(name = "valor_total_alugueis")
    private double valorTotalAlugueis; 

    @Column(name = "observacoes_alugueis", length = 45)
    private String observacoesAlugueis; 

    // @Enumerated(EnumType.STRING)
    // @Column(name = "status_alugueis", length = 20)
    // private StatusAluguel statusAlugueis;

    @ManyToOne
    @JoinColumn(name = "carros_id_carros")
    private CarrosModel carro;
    @Column(name = "nomeCliente", length = 45)
    private String nomeCliente; 

    @Column(name = "endereco", length = 45)
    private String endereco; 
}
