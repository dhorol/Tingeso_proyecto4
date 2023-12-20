import React, { useState } from 'react';
import './ProyectorForm.css';

const ProyectorForm = ({ onAddProyector }) => {
    const [marca, setMarca] = useState('EPSON');
    const [estado, setEstado] = useState('Buenas Condiciones');

    const handleSubmit = (e) => {
        e.preventDefault();
        onAddProyector({ marca, estado });
    };

    return (
        <div className="form-container"> {/* Contenedor con estilo */}
            <form onSubmit={handleSubmit}>
                <div className="form-group"> {/* Estilo para cada grupo de formulario */}
                    <label>Marca:</label>
                    <select name="marca" value={marca} onChange={(e) => setMarca(e.target.value)}>
                        <option value="EPSON">EPSON</option>
                        <option value="ViewSonic">ViewSonic</option>
                    </select>
                </div>
                <div className="form-group">
                    <label>Estado:</label>
                    <select name="estado" value={estado} onChange={(e) => setEstado(e.target.value)}>
                        <option value="Buenas Condiciones">Buenas Condiciones</option>
                        <option value="Con Daños">Con Daños</option>
                    </select>
                </div>
                <button type="submit" className="submit-btn">Agregar Proyector</button> {/* Botón con estilo */}
            </form>
        </div>
    );
};

export default ProyectorForm;
