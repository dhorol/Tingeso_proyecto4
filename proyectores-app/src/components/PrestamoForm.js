import React, { useState } from 'react';
import './PrestamoForm.css'; // Asegúrate de importar el CSS aquí

const PrestamoForm = ({ onAddPrestamo }) => {
    const [prestamoData, setPrestamoData] = useState({
        profesorId: '',
        proyectorId: '',
        uso: ''
    });

    const [mensaje, setMensaje] = useState('');
    const [esError, setEsError] = useState(false); // Nuevo estado para manejar si es un error

    const handleChange = (e) => {
        const { name, value } = e.target;
        const updatedValue = name === 'profesorId' || name === 'proyectorId' ? Number(value) : value;
        setPrestamoData({ ...prestamoData, [name]: updatedValue });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        // Obtener la fecha y hora actual en UTC
        let fechaUTC = new Date();

        // Ajustar a GMT-3
        let fechaLocal = new Date(fechaUTC.setHours(fechaUTC.getHours() - 3)).toISOString();

        // Crear el objeto de préstamo con la fecha y hora local
        const prestamoConFecha = { ...prestamoData, fechaPrestamo: fechaLocal };
        try {
            await onAddPrestamo(prestamoConFecha);
            setMensaje('Préstamo agregado con éxito.');
            setEsError(false); // No es un error
            setPrestamoData({
                profesorId: '',
                proyectorId: '',
                uso: ''
            });
        } catch (error) {
            setMensaje('Error al agregar el préstamo.');
            setEsError(true); // Es un error
        }
    };

    return (
        <div className="form-container">
            {mensaje && <div className={`mensaje ${esError ? 'error' : ''}`}>{mensaje}</div>}
            <form onSubmit={handleSubmit}>
                <div>
                    <label>ID del Profesor:</label>
                    <input
                        type="number" // Cambiado de "integer" a "number"
                        name="profesorId"
                        value={prestamoData.profesorId}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>ID del Proyector:</label>
                    <input
                        type="number" // Cambiado de "integer" a "number"
                        name="proyectorId"
                        value={prestamoData.proyectorId}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Uso del Proyector:</label>
                    <select
                        name="uso"
                        value={prestamoData.uso}
                        onChange={handleChange}
                    >
                        <option value="">Selecciona un uso</option>
                        <option value="Dictado de Clases">Dictado de Clases</option>
                        <option value="Exámenes de Título">Exámenes de Título</option>
                        <option value="Reuniones Varias">Reuniones Varias</option>
                    </select>
                </div>
                <button type="submit">Agregar Préstamo</button>
            </form>
        </div>
    );
};

export default PrestamoForm;
