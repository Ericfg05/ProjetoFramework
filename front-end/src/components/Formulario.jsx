import { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import DadosCarro from './DadosCarro';
import MyButton from './MyButton';
import './Formulario.css';

function Formulario() {
  const navigate = useNavigate();
  const location = useLocation();
  const carro = location.state?.carro;

  const [dataInicio, setDataInicio] = useState('');
  const [dataFim, setDataFim] = useState('');
  const [valorTotal, setValorTotal] = useState(0);

  useEffect(() => {
    if (dataInicio && dataFim && carro?.preco) {
      const inicio = new Date(dataInicio);
      const fim = new Date(dataFim);
      if (fim >= inicio) {
        const diffEmDias = Math.ceil((fim - inicio) / (1000 * 60 * 60 * 24));
        const total = diffEmDias * carro.preco;
        setValorTotal(total.toFixed(2));
      } else {
        setValorTotal(0);
      }
    }
  }, [dataInicio, dataFim, carro]);

  const handleSubmit = async () => {
    const nome = document.getElementById("nome").value;
    const endereco = document.getElementById("endereco").value;
    const observacoes = document.getElementById("observacoes").value;

    if (!dataInicio || !dataFim || !nome || !endereco) {
      alert("Preencha todos os campos obrigatórios.");
      return;
    }

    const payload = {
        idCarro: carro?.id, // <- usado para relacionar o carro
        dataInicioAlugueis: dataInicio,
        dataFimAlugueis: dataFim,
        observacoesAlugueis: observacoes,
        nomeCliente: nome,
        endereco: endereco,
        valorTotalAlugueis: Number(valorTotal) // <- garanta que é número, não string
      };
      console.log(payload);
    try {
      const response = await fetch("http://localhost:8080/alugueis/cada", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(payload)
      });
      console.log(response)
      if (!response.ok) {
        throw new Error("Erro ao salvar o aluguel.");
      }

      const data = await response.json();
      console.log("Aluguel salvo com sucesso:", data);
      navigate('/');
    } catch (err) {
      console.error(err);
      alert("Erro ao conectar com o servidor.");
    }
  };

  return (
    <>
      <DadosCarro
        modelo={carro?.modelo || ""}
        marca={carro?.marca || ""}
        placa={carro?.placa || ""}
        ano={carro?.ano || ""}
        cor={carro?.cor || ""}
        status={carro?.status || ""}
        valor={carro?.preco || ""}
        mostrarBotoes={false}
      />

      <div className='dados-pessoais'>
        <h1>Dados pessoais</h1>
        <input type="text" id="nome" placeholder='Nome completo' required />
        <input type="tel" id="telefone" placeholder='Telefone' />
        <input type="email" id="email" placeholder='Email' />
        <input type="text" id="cpf" placeholder='CPF' />
        <input type="text" id="endereco" placeholder='Endereço' required />
      </div>

      <div className='aluguel'>
        <h1>Informações do aluguel</h1>
        <input type="date" onChange={e => setDataInicio(e.target.value)} required />
        <input type="date" onChange={e => setDataFim(e.target.value)} required />
        <input type="text" id="observacoes" placeholder='Observações' />
        <input type="text" value={`Valor total: R$ ${valorTotal}`} readOnly />
      </div>

      <MyButton label='Concluir' onClick={handleSubmit} />
    </>
  );
}

export default Formulario;