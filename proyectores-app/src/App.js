import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomePage from './pages/HomePage';
import ProyectoresPage from './pages/ProyectoresPage';
import ProfesoresPage from './pages/ProfesoresPage';
import PrestamosPage from './pages/PrestamosPage';
import DevolucionesPage from './pages/DevolucionesPage';


// Importa otros componentes necesarios

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/proyectores" element={<ProyectoresPage />} />
                <Route path="/profesores" element={<ProfesoresPage />} />
                <Route path="/prestamos" element={<PrestamosPage />} />
                <Route path="/devoluciones" element={<DevolucionesPage />} />
                {/* ... otras rutas ... */}
            </Routes>
        </Router>
    );
}

export default App;
