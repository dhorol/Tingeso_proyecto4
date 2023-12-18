import React, { useEffect, useState } from 'react';
import { getProfesores } from '../services/profesorService';

const ProfesoresPage = () => {
    const [profesores, setProfesores] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const data = await getProfesores();
            setProfesores(data);
        };

        fetchData();
    }, []);

    return (
        <div>
            <h2>Lista de Profesores</h2>
            <table className="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Departamento</th>
                    {/* Agrega más columnas según los datos de los profesores */}
                </tr>
                </thead>
                <tbody>
                {profesores.map(profesor => (
                    <tr key={profesor.id}>
                        <td>{profesor.id}</td>
                        <td>{profesor.nombre}</td>
                        <td>{profesor.departamento}</td>
                        {/* Agrega más celdas según los datos de los profesores */}
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ProfesoresPage;
