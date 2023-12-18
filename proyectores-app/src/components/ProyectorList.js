import React from 'react';

const ProyectorList = ({ proyectores }) => {
    return (
        <div>
            <h2>Lista de Proyectores</h2>
            <table className="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Marca</th>
                    <th>Estado</th>
                </tr>
                </thead>
                <tbody>
                {proyectores.map(proyector => (
                    <tr key={proyector.id}>
                        <td>{proyector.id}</td>
                        <td>{proyector.marca}</td>
                        <td>{proyector.estado}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ProyectorList;
