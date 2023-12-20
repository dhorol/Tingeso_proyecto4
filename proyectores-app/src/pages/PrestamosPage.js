import React from 'react';

import { createPrestamo } from '../services/prestamosService';
import PrestamoForm from '../components/PrestamoForm';


const PrestamosPage = () => {
    const handleAddPrestamo = async (prestamoData) => {
        try {
            await createPrestamo(prestamoData);
        } catch (error) {
            console.error('Error al agregar un préstamo', error);
        }
    };

    return (
        <div className="prestamos-container">
            <div className="titulo-prestamos">
                <h2>Gestión de Préstamos</h2>
            </div>
            <PrestamoForm onAddPrestamo={handleAddPrestamo} />
        </div>
    );
};

export default PrestamosPage;