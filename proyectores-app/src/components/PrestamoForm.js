import React, { useState } from 'react';

const PrestamoForm = ({ onAddPrestamo }) => {
    const [prestamoData, setPrestamoData] = useState({
        // Inicializa aquí los campos necesarios para un préstamo
    });

    const handleChange = (e) => {
        setPrestamoData({ ...prestamoData, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        onAddPrestamo(prestamoData);
    };

    return (
        <form onSubmit={handleSubmit}>
            {/* Campos del formulario aquí */}
            <button type="submit">Agregar Préstamo</button>
        </form>
    );
};

export default PrestamoForm;
