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
      <p className='marca'>{marca} <br /> {ano} <br /> {cor} <br /> {status}</p>
      
      {/* Mostra o nome do cliente somente se o carro estiver alugado */}
      {status !== "DISPONIVEL" && nomeCliente && (
        <p className='NomeCliente'>Alugado por: {nomeCliente}</p>
      )}
      <span className="preco">Valor: R$ {preco}</span>

      <div className='card-bottom'>
        <button
          className={`botao ${status === "INDISPONIVEL" || status === "ALUGADO" ? "indisponivel" : ""}`}
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