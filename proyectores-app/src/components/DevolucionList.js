import React from 'react';

const DevolucionList = ({ devoluciones }) => {

    if (!devoluciones) {
        return <div>Cargando devoluciones...</div>;
    }
    return (
        <div className="lista-devoluciones">
            <h2>Lista de Devoluciones</h2>
            <table className="tabla-estilo">
                <thead>
                <tr>
                    <th>Fecha Devolución</th>
                    <th>Estado Devolución</th>
                    <th>ID Préstamo</th>
                </tr>
                </thead>
                <tbody>
                {devoluciones.map(devolucion => (
                    <tr key={devolucion.id}>
                        <td>{devolucion.fechaDevolucion}</td>
                        <td>{devolucion.estadoDevolucion}</td>
                        <td>{devolucion.prestamoId}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default DevolucionList;
