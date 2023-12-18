import React, { useEffect, useState } from 'react';
import { getProyectores } from '../services/proyectorService';
import ProyectorList from '../components/ProyectorList';

const ProyectoresPage = () => {
    const [proyectores, setProyectores] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const data = await getProyectores();
            setProyectores(data);
        };

        fetchData();
    }, []);

    return (
        <div>
            <h2>Gestión de Proyectores</h2>
            <ProyectorList proyectores={proyectores} />
        </div>
    );
};

export default ProyectoresPage;
