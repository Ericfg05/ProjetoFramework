import './Card.css'
import { useNavigate } from 'react-router-dom';

function Card({ id, imagem, nome, marca, preco, cor, ano, status, nomeCliente, desabilitarBotao, placa }) {
  const navigate = useNavigate();

  const handleClick = () => {
    const carro = { id, modelo: nome, marca, ano, cor, status, preco, placa };
    navigate('/alugar', { state: { carro } });
  };

  return (
    <div className="card">
      <img src={imagem} alt='Card' />
      <h2 className='titulo'>{nome}</h2>
      <p className='titulo'>{marca}</p>
      <p className='ano'>{ano}</p>
      <p className='cor'>{cor}</p>
      <p className='Status'>{status}</p>

      {/* Mostra o nome do cliente somente se o carro estiver alugado */}
      {status !== "DISPONIVEL" && nomeCliente && (
        <p className='NomeCliente'>Alugado por: {nomeCliente}</p>
      )}

      <div className='card-bottom'>
        <span className="preco">{preco}</span>
        <button
        className='botao'
        disabled={desabilitarBotao}
        onClick={handleClick}
        >
        {status === "INDISPONIVEL" || status === "ALUGADO" ? "Indisponível" : "Alugar"}
        </button>
      </div>
    </div>
  );
}

export default Card;