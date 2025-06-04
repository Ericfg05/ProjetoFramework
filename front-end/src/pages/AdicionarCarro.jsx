import Navbar from '../components/Navbar'
import Footer from '../components/Footer'
import FormularioAdicionar from '../components/FormularioAdicionar'
import './StyleGeral.css'
import MyButton from '../components/MyButton'
import axios from 'axios';
import { useState } from 'react';

export const axiosInstance = axios.create({
    baseURL: "http://localhost:8080"
});

function AdicionarCarro(){
    const [carro, setCarro] = useState({
        modelo_carros: '',
        marca_carros: '',
        placa_carros: '',
        ano_carros: '',
        cor_carros: '',
        status_carros: '',
        imagens_carros: '',
        valor_carros: 0
    });

    const handleChange = (e) => {
        setCarro({ ...carro, [e.target.id]: e.target.value });
    };

    const inserir = () => {
        axiosInstance.post("/carros/cadastrar", carro)
            .then(() => {
                alert("Carro cadastrado com sucesso!");
                setCarro({
                    modelo_carros: '',
                    marca_carros: '',
                    placa_carros: '',
                    ano_carros: '',
                    cor_carros: '',
                    status_carros: '',
                    imagens_carros: '',
                    valor_carros: 0
                });
            })
            .catch(() => {
                alert("Erro ao cadastrar carro.");
            });
    };

    return (
        <div className='layout'>
            <Navbar />
            <main>
                <FormularioAdicionar carro={carro} onChange={handleChange} />
                <MyButton label='Adicionar' onClick={inserir}/>
            </main>
            <Footer />
        </div>  
    )
    setCarro({
        modelo_carros: '',
        marca_carros: '',
        placa_carros: '',
        ano_carros: '',
        cor_carros: '',
        status_carros: '',
        imagens_carros: '',
        valor_carros: 0
    });
}

export default AdicionarCarro;