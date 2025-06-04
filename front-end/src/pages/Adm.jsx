import './StyleGeral.css'
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom'
import Navbar from '../components/Navbar'
import Footer from '../components/Footer'
import DadosCarro from '../components/DadosCarro'
import '../components/DadosCarro.css'
import MyButton from '../components/MyButton'

// a variável abaixo foi colocada apenas para simular os dados do banco
// favor, apagar ao conectar com o banco
const Adm =()=>{
    const [carros, setCarros] = useState([]);
    
      useEffect(() => {
        fetch('http://localhost:8080/carros') // URL do seu back-end
          .then(response => response.json())
          .then(data => setCarros(data))
          .catch(error => {
            console.error("Erro ao buscar carros:", error);
          });
      }, []);
     
  const navigate = useNavigate();

    return(
        <div className='layout'>
            <Navbar/>
            <main>
                <h1 className='adm'>CARROS CADASTRADOS</h1><br />
                <MyButton label='Adicionar carro' onClick={() => navigate('/adicionar-carro')} />
                {carros.map((carro) => (
                    <DadosCarro
                    key={carro.id_carros}
                   
                    className="adm" //esse parâmetro não deve ser alterado
                    mostrarBotoes={true} //esse parâmetro nao deve ser alterado
                    modelo={carro.modelo_carros}
                    marca={carro.marca_carros}
                    placa={carro.placa_carros}
                    ano={carro.ano_carros}
                    cor={carro.cor_carros}
                    status={carro.status_carros}
                    valor={carro.valor_carros}
                    nomeCliente='' // nome do cliente que alugou o carro vai aqui
                    id = {carro.id_carros}
                   
                    
                    />
                ))} 
                <br /><br /><br />
            </main>
            <Footer/>
        </div>
    )
}

export default Adm