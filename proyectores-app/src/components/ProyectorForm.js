import React, { useState } from 'react';

const ProyectorForm = ({ onAddProyector }) => {
    const [marca, setMarca] = useState('EPSON');
    const [estado, setEstado] = useState('Nuevo');

    const handleSubmit = (e) => {
        e.preventDefault();
        onAddProyector({ marca, estado });
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Marca:</label>
                <select value={marca} onChange={(e) => setMarca(e.target.value)}>
                    <option value="EPSON">EPSON</option>
                    <option value="ViewSonic">ViewSonic</option>
                </select>
            </div>
            <div>
                <label>Estado:</label>
                <select value={estado} onChange={(e) => setEstado(e.target.value)}>
                    <option value="Nuevo">Nuevo</option>
                    <option value="Con Daños">Con Daños</option>
                </select>
            </div>
            <button type="submit">Agregar Proyector</button>
        </form>
    );
};

export default ProyectorForm;
