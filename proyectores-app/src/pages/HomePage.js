// HomePage.js
import React from 'react';
import { Link } from 'react-router-dom';
import './HomePage.css'; // Asegúrate de importar el archivo CSS

const HomePage = () => {
    return (
        <div className="home-container">
            <div className="header">
                <h1>Bienvenido al Sistema de Gestión de Data Proyectores</h1>
            </div>
            <div className="menu">
                <ul>
                    <li><Link to="/proyectores">Gestionar Data Proyectores</Link></li>
                    <li><Link to="/profesores">Gestionar Profesores</Link></li>
                    <li><Link to="/prestamos">Gestionar Préstamos</Link></li>
                    <li><Link to="/devoluciones">Gestionar Devoluciones</Link></li>
                    <li><Link to="/reportes">Ver Reportes</Link></li>
                </ul>
            </div>
        </div>
    );
};

export default HomePage;
