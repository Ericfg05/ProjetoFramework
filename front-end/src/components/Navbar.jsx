import { Link } from 'react-router-dom'
import './Navbar.css'
import logo from '../assets/logo.png'

function Navbar (){
    return(
        <nav>
            <div className='navbar'>
                <Link to="/">
                    <img src={logo} alt="Aluga Aqui" className='logo'/>
                </Link>
                <ul className='list'>
                    <li className='item'>
                        <Link to="/">Home</Link>
                    </li>
                    <li className='item'>
                        <Link to="/adm">Administração</Link>
                    </li>
                </ul>  
            </div>
            <div className='linha'></div>
        </nav>
    )
}

export default Navbar