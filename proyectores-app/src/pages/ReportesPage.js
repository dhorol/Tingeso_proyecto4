// ReportesPage.js
import React, { useEffect, useState } from 'react';
import { getReportes } from '../services/reporteService';
import './ReportesPage.css'; // Asegúrate de importar el archivo CSS

const ReportesPage = () => {
    const [reportes, setReportes] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const data = await getReportes();
            setReportes(data);
        };

        fetchData();
    }, []);

    return (
        <div className="reportes-container">
            <h2>Reportes de Préstamos y Devoluciones</h2>
            <table>
                <thead>
                <tr>
                    <th>Fecha Préstamo</th>
                    <th>Fecha Devolución</th>
                    <th>Profesor</th>
                    <th>Marca Proyector</th>
                    <th>Estado Devolución</th>
                    <th>Uso Proyector</th>
                    <th>Duración Préstamo (Horas)</th>
                </tr>
                </thead>
                <tbody>
                {reportes.map(reporte => (
                    <tr key={reporte.fechaPrestamo}>
                        <td>{reporte.fechaPrestamo}</td>
                        <td>{reporte.fechaDevolucion}</td>
                        <td>{reporte.nombreProfesor}</td>
                        <td>{reporte.marcaProyector}</td>
                        <td>{reporte.estadoDevolucion}</td>
                        <td>{reporte.usoProyector}</td>
                        <td>{reporte.duracionPrestamoEnHoras}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ReportesPage;
