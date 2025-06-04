// package com.alugaaqui.aluga_aqui.model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Entity
// @Table(name="clientes")
// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor

// public class ClientesModel {
    
//     @Id
//     @Column(name = "id_clientes")
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @Column(name = "nome_completo", nullable = false, length = 45)
//     private String nome_completo; 

//     @Column(name = "email",  unique = true, nullable = false, length = 45)
//     private String email;

//     @Column(name = "telefone", nullable = false, length = 45)
//     private String telefone;

//     @Column(name = "endereco", nullable = false, length = 80)
//     private String endereco;


//     @Column(name = "cpf_clientes", nullable = false, unique = true, length = 14)
//     private String cpf_clientes; 

   
// }
