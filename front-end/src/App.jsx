import { Routes, Route } from 'react-router-dom'
import Home from './pages/Home.jsx'
import Alugar from './pages/Alugar.jsx'
import AdicionarCarro from './pages/AdicionarCarro.jsx'
import Adm from './pages/Adm.jsx'

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/alugar" element={<Alugar />} />
      <Route path="/adicionar-carro" element={<AdicionarCarro />} />
      <Route path="/adm" element={<Adm />} />
    </Routes>
  )
}

export default App
