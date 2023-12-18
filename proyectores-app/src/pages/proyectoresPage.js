import React, { useEffect, useState } from 'react';
import { getProyectores, addProyector, updateProyector } from '../services/proyectorService';
import ProyectorList from '../components/ProyectorList';
import ProyectorForm from '../components/ProyectorForm';

const ProyectoresPage = () => {
    const [proyectores, setProyectores] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const data = await getProyectores();
            setProyectores(data);
        };

        fetchData();
    }, []);

    const handleAddProyector = async (proyectorData) => {
        const newProyector = await addProyector(proyectorData);
        setProyectores([...proyectores, newProyector]);
    };

    const handleUpdateProyector = async (id) => {
        const proyectorToUpdate = proyectores.find(p => p.id === id);
        if (proyectorToUpdate) {
            const updatedProyector = await updateProyector(id, { ...proyectorToUpdate, estado: 'Nuevo' });
            setProyectores(proyectores.map(p => p.id === id ? updatedProyector : p));
        }
    };

    return (
        <div>
            <h2>Gestión de Proyectores</h2>
            <ProyectorForm onAddProyector={handleAddProyector} />
            <ProyectorList
                proyectores={proyectores}
                onUpdateProyector={handleUpdateProyector}
            />
        </div>
    );
};

export default ProyectoresPage;
