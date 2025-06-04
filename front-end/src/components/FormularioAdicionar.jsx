import './Formulario.css'

function FormularioAdicionar({ carro, onChange }) {
    return (
        <div className='dados-pessoais'>
            <h1>Adicionar carro</h1>

            <input type="text" id="modelo_carros" placeholder='Modelo'
                value={carro.modelo_carros} onChange={onChange} />

            <input type="text" id="marca_carros" placeholder='Marca'
                value={carro.marca_carros} onChange={onChange} />

            <input type="text" id="placa_carros" placeholder='Placa'
                value={carro.placa_carros} onChange={onChange} />

            <input type="text" id="ano_carros" placeholder='Ano'
                value={carro.ano_carros} onChange={onChange} />

            <input type="text" id="cor_carros" placeholder='Cor'
                value={carro.cor_carros} onChange={onChange} />

            <input type="text" id="status_carros" placeholder='Status'
                value={carro.status_carros} onChange={onChange} />

            <input type="text" id="imagens_carros" placeholder='Link da imagem'
                value={carro.imagens_carros} onChange={onChange} />

            <input type="number" id="valor_carros" placeholder='Valor'
                value={carro.valor_carros} onChange={onChange} />
        </div>
    );
}

export default FormularioAdicionar;