import React, { useEffect, useState } from 'react';
import { getProfesores, addProfesor, deleteProfesor } from '../services/profesorService';
import ProfesorList from '../components/ProfesorList';
import ProfesorForm from '../components/ProfesorForm';

const ProfesoresPage = () => {
    const [profesores, setProfesores] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const data = await getProfesores();
            setProfesores(data);
        };

        fetchData();
    }, []);

    const handleAddProfesor = async (profesorData) => {
        const newProfesor = await addProfesor(profesorData);
        setProfesores([...profesores, newProfesor]);
    };

    const handleDeleteProfesor = async (id) => {
        await deleteProfesor(id);
        setProfesores(profesores.filter(p => p.id !== id));
    };

    return (
        <div>
            <h2>Lista de Profesores</h2>
            <ProfesorForm onAddProfesor={handleAddProfesor} />
            <ProfesorList
                profesores={profesores}
                onDeleteProfesor={handleDeleteProfesor}
            />
        </div>
    );
};

export default ProfesoresPage;
