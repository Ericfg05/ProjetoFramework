import "./DadosCarro.css"

import React, { useState, useEffect } from 'react';

const EditarCarro = ({ 
  isOpen, 
  onClose, 
  modelo, 
  marca, 
  placa, 
  ano, 
  cor, 
  valor, 
  status,
  idCarro,            // id para identificar o carro na API
  onUpdateSuccess     // callback para atualizar lista após editar
}) => {
  if (!isOpen) return null;

  // Inicializa o formData quando os props mudam (útil se o modal reabrir com outro carro)
  const [formData, setFormData] = useState({
    modelo: modelo || '',
    marca: marca || '',
    placa: placa || '',
    ano: ano || '',
    cor: cor || '',
    valor: valor || '',
    status: status || '',
    id: idCarro
  });

  useEffect(() => {
    setFormData({
      modelo: modelo || '',
      marca: marca || '',
      placa: placa || '',
      ano: ano || '',
      cor: cor || '',
      valor: valor || '',
      status: status || ''
      
    });
  }, [modelo, marca, placa, ano, cor, valor, status]);
  console.log(idCarro);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSave = async () => {
    setLoading(true);
    setError(null);
  
    try {
      const response = await fetch(`http://localhost:8080/carros/editar/${idCarro}`, {
       
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        
        body: JSON.stringify({
          id_carros: idCarro,
          modelo_carros: formData.modelo,
          marca_carros: formData.marca,
          placa_carros: formData.placa,
          ano_carros: formData.ano,
          cor_carros: formData.cor,
          valor_carros: parseFloat(formData.valor),
          status_carros: formData.status,
          imagens_carros: "" // ajuste conforme o necessário
        }),
      });
  console.log(response);
      if (!response.ok) throw new Error('Erro ao atualizar o carro');
  
      const data = await response.json();
      onUpdateSuccess(data); // Atualiza a lista
      onClose();             // Fecha o modal
    } catch (err) {
      setError(err.message || 'Erro desconhecido');
    } finally {
      setLoading(false);
    }
  };

   

  return (
    <div className='overlay'>
      <div className='modal'>
        <h2 className='tituloEditar'>Editar Carro</h2>
        <input id="modelo" type="text" name="modelo" placeholder="Modelo" value={formData.modelo} onChange={handleChange} />
        <input id="marca" type="text" name="marca" placeholder="Marca" value={formData.marca} onChange={handleChange} />
        <input id="placa" type="text" name="placa" placeholder="Placa" value={formData.placa} onChange={handleChange} />
        <input id="ano" type="text" name="ano" placeholder="Ano" value={formData.ano} onChange={handleChange} />
        <input id="cor" type="text" name="cor" placeholder="Cor" value={formData.cor} onChange={handleChange} />
        <input type="number" step="0.01" name="valor" placeholder="Valor" value={formData.valor} onChange={handleChange} />
        <select className="status" name="status" value={formData.status} onChange={handleChange}>
          <option value="">Selecione o status</option>
          <option value="DISPONIVEL">Disponível</option>
          <option value="INDISPONIVEL">Indisponível</option>
          <option value="ALUGADO">Alugado</option>
        </select>
        {error && <p style={{ color: 'red' }}>{error}</p>}
        <br />
        <div className='actions'>
          <button className='btnCancelarEditar' onClick={onClose} disabled={loading}>Fechar</button>
          <button className='btnSalvarEditar' onClick={handleSave} disabled={loading}>
            {loading ? 'Salvando...' : 'Salvar'}
          </button>
        </div>
      </div>
    </div>
  );
};

export default EditarCarro;