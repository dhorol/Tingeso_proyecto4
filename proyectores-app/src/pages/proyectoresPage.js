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

    return <ProyectorList proyectores={proyectores} />;
};

export default ProyectoresPage;
