import axios from 'axios';

const API_URL = 'http://localhost:8080/proyectores';

const getProyectores = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data;
    } catch (error) {
        console.error('Error al obtener los proyectores', error);
    }
};

// Más funciones para añadir, editar, eliminar proyectores

export { getProyectores };
