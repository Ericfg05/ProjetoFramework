// package com.alugaaqui.aluga_aqui.controller;

// import java.util.List;
// import java.util.Optional;
 
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.alugaaqui.aluga_aqui.model.ClientesModel;
// import com.alugaaqui.aluga_aqui.service.ClienteServices;

// import jakarta.persistence.EntityNotFoundException;

// @RestController
// @RequestMapping("/api/clientes") // Caminho base 
// public class ClienteController {

//     @Autowired
//     private ClienteServices clienteServices;


//     @PostMapping
//     public ResponseEntity<?> adicionarCliente(@RequestBody ClientesModel cliente) {
//         try {
//             ClientesModel novoCliente = clienteServices.salvarCliente(cliente);
//             return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
//         } catch (IllegalArgumentException e) {
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//         } catch (Exception e) {
//             // Logar a exceção 
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar cliente: " + e.getMessage());
//         }
//     }


//     @GetMapping
//     public ResponseEntity<List<ClientesModel>> listarTodosClientes() {
//         List<ClientesModel> clientes = clienteServices.listarTodosClientes();
//         return ResponseEntity.ok(clientes);
//     }


//     @GetMapping("/{id}")
//     public ResponseEntity<ClientesModel> buscarClientePorId(@PathVariable Long id) {
//         Optional<ClientesModel> clienteOpt = clienteServices.buscarClientePorId(id);
//         return clienteOpt.map(ResponseEntity::ok)
//                          .orElseGet(() -> ResponseEntity.notFound().build());
//     }


//     /*@GetMapping("/buscar")
//     public ResponseEntity<List<ClientesModel>> buscarClientesPorNome(@RequestParam String nomeParcial) {
//     List<ClientesModel> clientes = clienteServices.buscarClientesPorNome(nomeParcial); 
//     return ResponseEntity.ok(clientes);
//     }*/

    
//   /*  @PutMapping("/{id}")
//     public ResponseEntity<?> atualizarCliente(@PathVariable Long id, @RequestBody ClientesModel clienteAtualizado) {
//         try {
//             ClientesModel clienteSalvo = clienteServices.atualizarCliente(id, clienteAtualizado);
//             return ResponseEntity.ok(clienteSalvo);
//         } catch (EntityNotFoundException e) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//         } catch (IllegalArgumentException e) {
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//         } catch (Exception e) {
//             // Logar a exceção
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar cliente: " + e.getMessage());
//         }
//     }*/

   
//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
//         try {
//             clienteServices.deletarCliente(id);
//             return ResponseEntity.noContent().build();
//         } catch (EntityNotFoundException e) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
//         } catch (Exception e) {
//             // Logar a exceção
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//         }
//     }




//    /* @GetMapping("/cpf/{cpf}")
//     public ResponseEntity<ClientesModel> buscarClientePorCpf(@PathVariable String cpf) {
//         Optional<ClientesModel> clienteOpt = clienteServices.buscarClientePorCpf(cpf);
//         return clienteOpt.map(ResponseEntity::ok)
//                          .orElseGet(() -> ResponseEntity.notFound().build());
//     }*/

 
//     /*@GetMapping("/email")
//     public ResponseEntity<ClientesModel> buscarClientePorEmail(@RequestParam String email) {
//         Optional<ClientesModel> clienteOpt = clienteServices.buscarClientePorEmail(email);
//         return clienteOpt.map(ResponseEntity::ok)
//                          .orElseGet(() -> ResponseEntity.notFound().build());
//     }*/

    
//     // @GetMapping("/cnh/{cnh}")
//     // public ResponseEntity<ClientesModel> buscarClientePorCnh(@PathVariable String cnh) {
//     //     Optional<ClientesModel> clienteOpt = clienteServices.buscarClientePorCnh(cnh);
//     //     return clienteOpt.map(ResponseEntity::ok)
//     //                      .orElseGet(() -> ResponseEntity.notFound().build());
//     // }
// }