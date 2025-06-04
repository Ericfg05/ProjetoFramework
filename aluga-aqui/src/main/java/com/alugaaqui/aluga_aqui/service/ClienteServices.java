// package com.alugaaqui.aluga_aqui.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.alugaaqui.aluga_aqui.model.ClientesModel;
// import com.alugaaqui.aluga_aqui.repositories.ClientesRepositories;

// import jakarta.persistence.EntityNotFoundException;

// @Service
// public class ClienteServices {

//     @Autowired
//     private ClientesRepositories clienteRepositories;
   

//     @Autowired
//     // private PasswordEncoder passwordEncoder;


//     public ClientesModel salvarCliente(ClientesModel cliente) {

//         // Validação de CPF único
//        /* if (cliente.getCpf_clientes() != null && clienteRepositories.findByCpf(cliente.getCpf_clientes()).isPresent()) {
//             throw new IllegalArgumentException("CPF já cadastrado: " + cliente.getCpf_clientes());
//         }

//         //Validar email único
//         if (cliente.getEmail() != null && clienteRepositories.findByEmail(cliente.getEmail()).isPresent()) {
//             throw new IllegalArgumentException("Email já cadastrado: " + cliente.getEmail());
//         }*/

//         //Validar CNH única
//         // if (cliente.getCnh() != null && clienteRepositories.findByCnh(cliente.getCnh()).isPresent()) {
//         //     throw new IllegalArgumentException("CNH já cadastrada: " + cliente.getCnh());
//         // }

//         //
//         //Alguma função de codificar a senha?
//         //
//         // if (cliente.getSenha() != null && !cliente.getSenha().isEmpty()) {
//         //     cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
//         // }

        

//         return clienteRepositories.save(cliente);
//     }


    
//     public List<ClientesModel> listarTodosClientes() {
//         return clienteRepositories.findAll();
//     }


    
//     public Optional<ClientesModel> buscarClientePorId(Long id) {
//         return clienteRepositories.findById(id);
//     }

  
//     /*public List<ClientesModel> buscarClientesPorNome(String nomeParcial) {
//         if (nomeParcial == null || nomeParcial.trim().isEmpty()) {
//             return List.of();
//         }
//         return clienteRepositories.findByNomeCompletoContainingIgnoreCase(nomeParcial);
//     }*/


//     // Validação de Email único se estiver sendo alterado
//    /*  public ClientesModel atualizarCliente(Long id, ClientesModel clienteAtualizado) {
//         ClientesModel clienteExistente = clienteRepositories.findById(id)
//                 .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + id));
//                 if (clienteAtualizado.getEmail() != null && !clienteAtualizado.getEmail().equals(clienteExistente.getEmail())) {
//                     if (clienteRepositories.findByEmail(clienteAtualizado.getEmail()).isPresent()) {
//                         throw new IllegalArgumentException("Email já cadastrado: " + clienteAtualizado.getEmail());
//                     }
//                     clienteExistente.setEmail(clienteAtualizado.getEmail());
//                 }
//                 // Validação de CNH única se estiver sendo alterada
//                 // if (clienteAtualizado.getCnh() != null && !clienteAtualizado.getCnh().equals(clienteExistente.getCnh())) {
//                 //     if (clienteRepositories.findByCnh(clienteAtualizado.getCnh()).isPresent()) {
//                 //         throw new IllegalArgumentException("CNH já cadastrada: " + clienteAtualizado.getCnh());
//                 //     }
//                 //     clienteExistente.setCnh(clienteAtualizado.getCnh());
//                 // }


//                 clienteExistente.setNome_completo(clienteAtualizado.getNome_completo());
//                 // clienteExistente.setDataNascimento(clienteAtualizado.getDataNascimento());
//                 clienteExistente.setTelefone(clienteAtualizado.getTelefone());
//                 clienteExistente.setEndereco(clienteAtualizado.getEndereco());
//                 // clienteExistente.setDataValidadeCnh(clienteAtualizado.getDataValidadeCnh());
//                 // clienteExistente.setCategoriaCnh(clienteAtualizado.getCategoriaCnh());

//                 return clienteRepositories.save(clienteExistente);
//     }*/



//     public void deletarCliente(Long id) {
//         if (!clienteRepositories.existsById(id)) {
//             throw new EntityNotFoundException("Cliente não encontrado com o ID: " + id);
//         }
//         clienteRepositories.deleteById(id);
//     }

//    /*  public Optional<ClientesModel> buscarClientePorCpf(String cpf) {
//         return clienteRepositories.findByCpf(cpf);
//     }

//     public Optional<ClientesModel> buscarClientePorEmail(String email) {
//         return clienteRepositories.findByEmail(email);
//     }*/

//     // public void buscarClientePorCnh(String cnh) {
//     //     return clienteRepositories.findByCnh(cnh);
//     // }
// }
