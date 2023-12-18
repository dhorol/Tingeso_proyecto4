import React, { useEffect, useState } from 'react';
import { getPrestamos, createPrestamo } from '../services/prestamoService';
import PrestamoForm from '../components/PrestamoForm';
import PrestamoList from '../components/PrestamoList';

const PrestamosPage = () => {
    const [prestamos, setPrestamos] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const data = await getPrestamos();
            setPrestamos(data);
        };
        fetchData();
    }, []);

    const handleAddPrestamo = async (prestamoData) => {
        const newPrestamo = await createPrestamo(prestamoData);
        setPrestamos([...prestamos, newPrestamo]);
    };

    return (
        <div>
            <h2>Gestión de Préstamos</h2>
            <PrestamoForm onAddPrestamo={handleAddPrestamo} />
            <PrestamoList prestamos={prestamos} />
        </div>
    );
};

export default PrestamosPage;
