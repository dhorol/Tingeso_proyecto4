import React, { useState } from 'react';

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
        <form onSubmit={handleSubmit}>
            <div>
                <label>Nombre:</label>
                <input
                    type="text"
                    value={nombre}
                    onChange={(e) => setNombre(e.target.value)}
                />
            </div>
            <div>
                <label>Departamento:</label>
                <input
                    type="text"
                    value={departamento}
                    onChange={(e) => setDepartamento(e.target.value)}
                />
            </div>
            <button type="submit">Agregar Profesor</button>
        </form>
    );
};

export default ProfesorForm;
