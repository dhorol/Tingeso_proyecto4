import React from 'react';

const DevolucionList = ({ devoluciones }) => {
    return (
        <div>
            <h2>Lista de Devoluciones</h2>
            <table className="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Fecha de Devolución</th>
                    <th>Estado</th>
                    {/* Otros campos necesarios */}
                </tr>
                </thead>
                <tbody>
                {devoluciones.map(devolucion => (
                    <tr key={devolucion.id}>
                        <td>{devolucion.id}</td>
                        <td>{devolucion.fechaDevolucion}</td>
                        <td>{devolucion.estado}</td>
                        {/* Otros campos */}
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default DevolucionList;
