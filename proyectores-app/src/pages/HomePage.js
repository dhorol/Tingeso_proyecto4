import React from 'react';
import { Link } from 'react-router-dom';

const HomePage = () => {
    return (
        <div>
            <h1>Bienvenido al Sistema de Gestión de Data Proyectores</h1>
            <p>Seleccione una de las siguientes opciones:</p>
            <ul>
                <li><Link to="/proyectores">Gestionar Data Proyectores</Link></li>
                <li><Link to="/profesores">Gestionar Profesores</Link></li>
                <li><Link to="/prestamos">Gestionar Préstamos</Link></li>
                <li><Link to="/devoluciones">Gestionar Devoluciones</Link></li>
                <li><Link to="/reportes">Ver Reportes</Link></li>
            </ul>
        </div>
    );
};

export default HomePage;
