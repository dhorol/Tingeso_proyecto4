import React, { useState } from 'react';
import './DevolucionForm.css'; // Importa el archivo de estilos CSS


const DevolucionForm = ({ prestamoId, onAddDevolucion }) => {
    const [devolucionData, setDevolucionData] = useState({
        fechaDevolucion: '', // Fecha y hora de devolución
        estadoDevolucion: '', // Estado de la devolución
        prestamoId: prestamoId
    });

    const handleChange = (e) => {
        setDevolucionData({ ...devolucionData, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        onAddDevolucion(devolucionData);
    };

    return (
        <form onSubmit={handleSubmit} className="form-estilo">
            <div className="input-group">
                <label>Fecha de Devolución:</label>
                <input type="datetime-local" name="fechaDevolucion" value={devolucionData.fechaDevolucion} onChange={handleChange} />
            </div>
            <div className="input-group">
                <label>Estado de Devolución:</label>
                <select
                    name="estadoDevolucion"
                    value={devolucionData.estadoDevolucion}
                    onChange={handleChange}
                >
                    <option value="">Seleccione un estado</option>
                    <option value="Buenas Condiciones">Buenas Condiciones</option>
                    <option value="Con Daños">Con Daños</option>
                </select>
            </div>

            <button type="submit" className="boton-formulario">Registrar Devolución</button>
        </form>
    );
};

export default DevolucionForm;