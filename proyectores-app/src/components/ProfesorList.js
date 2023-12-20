import React from 'react';

const ProfesorList = ({ profesores, onDeleteProfesor, onToggleHabilitacion }) => {
    if (!profesores) {
        return <div>Cargando profesores...</div>;
    }
    return (
        <div>
            <h2>Lista de Profesores</h2>
            <table className="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Departamento</th>
                    <th>Habilitado</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                {profesores.map(profesor => (
                    <tr key={profesor.id}>
                        <td>{profesor.id}</td>
                        <td>{profesor.nombre}</td>
                        <td>{profesor.departamento}</td>
                        <td>{profesor.habilitado ? 'Sí' : 'No'}</td>
                        <td>
                            <button onClick={() => onDeleteProfesor(profesor.id)}>
                                Eliminar
                            </button>
                            <button onClick={() => onToggleHabilitacion(profesor.id)}>
                                {profesor.habilitado ? 'Deshabilitar' : 'Habilitar'}
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ProfesorList;
