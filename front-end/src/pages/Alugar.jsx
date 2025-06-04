import Navbar from '../components/Navbar'
import Footer from '../components/Footer'
import Formulario from '../components/Formulario'
import './StyleGeral.css'

function Alugar(){
    return(
        <div className='layout'>
            <Navbar /> 
            <main>
                <Formulario/>
            </main>
            <Footer />
        </div>  

    )
}

export default Alugar