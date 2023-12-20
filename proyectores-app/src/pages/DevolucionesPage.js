import React, { useEffect, useState } from 'react';
import { getPrestamosPendientes, createDevolucion } from '../services/devolucionService';
import DevolucionForm from '../components/DevolucionForm';
import './DevolucionesPage.css'; // Asegúrate de tener este archivo CSS para estilos

const DevolucionesPage = () => {
    const [prestamosPendientes, setPrestamosPendientes] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const data = await getPrestamosPendientes();
                setPrestamosPendientes(data);
            } catch (error) {
                console.error('Error al cargar los préstamos pendientes', error);
            }
        };
        fetchData();
    }, []);

    const handleAddDevolucion = async (devolucionData) => {
        try {
            await createDevolucion(devolucionData);
            // Actualiza la lista de préstamos pendientes después de la devolución
            const data = await getPrestamosPendientes();
            setPrestamosPendientes(data);
        } catch (error) {
            console.error('Error al registrar la devolución', error);
        }
    };

    return (
        <div className="devoluciones-container">
            <h2>Gestión de Devoluciones</h2>
            <div className="devolucion-form">
                {prestamosPendientes.map((prestamo) => (
                    <div key={prestamo.id} className="devolucion-item">
                        <h3>Préstamo ID: {prestamo.id}</h3>
                        <DevolucionForm prestamoId={prestamo.id} onAddDevolucion={handleAddDevolucion} />
                    </div>
                ))}
            </div>
        </div>
    );
};

export default DevolucionesPage;
