import React from 'react';

const PrestamoList = ({ prestamos }) => {
    return (
        <div>
            <h2>Lista de Préstamos</h2>
            <table className="table">
                <thead>
                <tr>
                    <th>Fecha</th>
                    <th>Hora</th>
                    {/* otros encabezados */}
                </tr>
                </thead>
                <tbody>
                {prestamos.map((prestamo) => (
                    <tr key={prestamo.id}>
                        <td>{prestamo.fechaPrestamo}</td>
                        <td>{prestamo.horaPrestamo}</td>
                        {/* otras celdas */}
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};
export default PrestamoList;
