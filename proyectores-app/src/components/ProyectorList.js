import React from 'react';

const ProyectorList = ({ proyectores, onUpdateProyector, onDeleteProyector }) => {
    return (
        <div>
            <h2>Lista de Proyectores</h2>
            <table className="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Marca</th>
                    <th>Estado</th>
                    <th>Disponibilidad</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                {proyectores.map(proyector => (
                    <tr key={proyector.id}>
                        <td>{proyector.id}</td>
                        <td>{proyector.marca}</td>
                        <td>{proyector.estado}</td>
                        <td>{proyector.disponible ? 'Disponible' : 'No Disponible'}</td>
                        <td>
                            {proyector.estado === 'Con Daños' && (
                                <button onClick={() => onUpdateProyector(proyector.id)}>Reparar</button>
                            )}
                            <button onClick={() => onDeleteProyector(proyector.id)}>Eliminar</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ProyectorList;
