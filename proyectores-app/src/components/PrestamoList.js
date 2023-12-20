import React from 'react';
import { format } from 'date-fns';

const PrestamoList = ({ prestamos }) => {
    if (!prestamos) {
        return <div>Cargando proyectores...</div>;
    }

    const formatDate = (dateString) => {
        const date = new Date(dateString);
        return format(date, 'dd/MM/yyyy HH:mm');
    };

    return (
        <div>
            <h2>Lista de Préstamos</h2>
            <table className="table">
                <thead>
                <tr>
                    <th>ID del Préstamo</th>
                    <th>Fecha de Préstamo</th>
                    <th>Nombre del Profesor</th>
                    <th>Marca del Proyector</th>
                    <th>Uso del Proyector</th>
                    <th>Fecha de Devolución</th>
                    <th>Estado de Devolución</th>
                </tr>
                </thead>
                <tbody>
                {prestamos.map((prestamos) => (
                    <tr key={prestamos.id}>
                        <td>{prestamos.id}</td>
                        <td>{formatDate(prestamos.fechaPrestamo)}</td>
                        <td>{prestamos.nombreProfesor}</td>
                        <td>{prestamos.marcaProyector}</td>
                        <td>{prestamos.usoProyector}</td>
                        <td>{prestamos.fechaDevolucion ? formatDate(prestamos.fechaDevolucion) : 'Pendiente'}</td>
                        <td>{prestamos.estadoDevolucion || 'Pendiente'}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default PrestamoList;
