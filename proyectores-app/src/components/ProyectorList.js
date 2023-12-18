import React from 'react';

const ProyectorList = ({ proyectores, onUpdateProyector }) => {
    return (
        <div>
            <h2>Lista de Proyectores</h2>
            <table className="table">
                <thead>
                <tr>
                    <th>Número del Proyector</th>
                    <th>Marca</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                {proyectores.map(proyector => (
                    <tr key={proyector.id}>
                        <td>{proyector.id}</td>
                        <td>{proyector.marca}</td>
                        <td>{proyector.estado}</td>
                        <td>
                            {proyector.estado === 'Con Daños' && (
                                <button onClick={() => onUpdateProyector(proyector.id)}>
                                    Reparar
                                </button>
                            )}
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ProyectorList;
