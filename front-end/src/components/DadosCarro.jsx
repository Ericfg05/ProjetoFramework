import './DadosCarro.css'
import EditarCarro from './EditarCarro';
import React, { useState, useEffect } from 'react';

const DadosCarro = ({id,modelo, marca, placa, ano, cor, status, valor, className='', mostrarBotoes, nomeCliente}) => {
  const [modalAberto, setModalAberto] = useState(false);

  const abrirEditarCarro = () => {
    setModalAberto(true);
  };

  const fecharEditarCarro = () => {
    setModalAberto(false);
  };

  const deletarCarro = (id) => {
      console.log(id);
        fetch(`http://localhost:8080/carros/remover/${id}`, {
          method: 'DELETE'
        })
        .then(response => {
          if (response.status === 204 || response.status === 200) {
            alert("Carro removido com sucesso!");
            window.location.reload();
  
          } else {
            alert("Erro ao remover o carro.");
          }
        })
        .catch(error => {
          console.error("Erro:", error);
          alert("Erro ao conectar com o servidor.");
        });
      };
    return(
        <div className={`dados-carro ${className}`}>
            <h4>Modelo: {modelo}</h4>
            <h4>Marca: {marca}</h4>
            <h4>Placa: {placa}</h4>
            <h4>Ano: {ano}</h4>
            <h4>Cor: {cor}</h4>
            <h4>Status: {status}</h4>
            <h4>Valor: {valor}</h4>
            {status === "Alugado" && <h4>Nome do cliente: {nomeCliente}</h4>}

            {mostrarBotoes && status !== "Alugado" && (
                <div>
                    <button className='remover' onClick={() => deletarCarro(id)}>Remover</button>
                    <button className='editar' onClick={abrirEditarCarro}>Editar</button>
                </div>
            )}

<EditarCarro
  isOpen={modalAberto}
  onClose={() => setModalAberto(false)}
  modelo={modelo}
  marca={marca}
  placa={placa}
  ano={ano}
  cor={cor}
  valor={valor}
  status={status}
  idCarro={id}   
  onUpdateSuccess={() => window.location.reload()}  
/>
        </div>
    )

}

export default DadosCarro