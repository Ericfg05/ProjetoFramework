import './StyleGeral.css';
import React, { useEffect, useState } from 'react';
import { register } from 'swiper/element/bundle';
register();
import 'swiper/css';

import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import Slider from '../components/Slider';
import Card from '../components/Card';

function Home() {
  const [carros, setCarros] = useState([]);
  const [alugueisMap, setAlugueisMap] = useState({});

  useEffect(() => {
    // Fetch de carros
    fetch('http://localhost:8080/carros')
      .then(response => response.json())
      .then(data => {
        setCarros(data);
      })
      .catch(error => {
        console.error("Erro ao buscar carros:", error);
      });
  
    // Fetch de alugueis
    fetch('http://localhost:8080/alugueis')
      .then(response => response.json())
      .then(data => {
        const map = {}; // ← AQUI estava faltando!
  
        data.forEach(aluguel => {
          const carroId = aluguel.carro.id_carros;
          const nomeCliente = aluguel.nomeCliente ?? "Cliente não informado";
          map[carroId] = nomeCliente;
        });
  
        setAlugueisMap(map);
      })
      .catch(error => {
        console.error("Erro ao buscar alugueis:", error);
      });
  }, []);

  return (
    <div className='layout'>
      <Navbar />
      <main>
        <Slider />
        <section className='card-list'>
          {carros.map((carro) => {
            const status = carro.status_carros;
            const alugado = status === "ALUGADO" || status === "INDISPONIVEL";
            const nomeCliente = alugueisMap[carro.id_carros];
            console.log(alugueisMap[carro.id_carros]);

            return (
              <Card
                key={carro.id_carros}
                id={carro.id_carros}
                nome={carro.modelo_carros}
                marca={carro.marca_carros}
                cor={carro.cor_carros}
                ano={carro.ano_carros}
                preco={carro.valor_carros}
                imagem={carro.imagens_carros}
                status={status}
                nomeCliente={alugado ?  nomeCliente : ""}
                desabilitarBotao={alugado}
                placa ={carro.placa_carros}
              />
            );
          })}
        </section>
      </main>
      <Footer />
    </div>
  );
}

export default Home;