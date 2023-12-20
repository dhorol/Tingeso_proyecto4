import React, { useEffect, useState } from 'react';
import { getProfesores, addProfesor, deleteProfesor } from '../services/profesorService';
import ProfesorList from '../components/ProfesorList';
import ProfesorForm from '../components/ProfesorForm';
import './ProfesoresPage.css';

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
        <div className="profesores-container">
            <div className="titulo-container">
                <h2>Lista de Profesores</h2>
            </div>
            <div className="profesor-form">
                <ProfesorForm onAddProfesor={handleAddProfesor} />
            </div>
            <div className="profesor-list">
                <ProfesorList
                    profesores={profesores}
                    onDeleteProfesor={handleDeleteProfesor}
                />
            </div>
        </div>
    );
};

export default ProfesoresPage;


