import React, { useState } from 'react';
import './ProfesorForm.css'; // Asegúrate de impo

const ProfesorForm = ({ onAddProfesor }) => {
    const [nombre, setNombre] = useState('');
    const [departamento, setDepartamento] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        onAddProfesor({ nombre, departamento });
        setNombre('');
        setDepartamento('');
    };

    return (
        <div className="form-container">
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Nombre:</label>
                    <input
                        type="text"
                        value={nombre}
                        onChange={(e) => setNombre(e.target.value)}
                    />
                </div>
                <div className="form-group">
                    <label>Departamento:</label>
                    <input
                        type="text"
                        value={departamento}
                        onChange={(e) => setDepartamento(e.target.value)}
                    />
                </div>
                <button type="submit">Agregar Profesor</button>
            </form>
        </div>
    );
};

export default ProfesorForm;
