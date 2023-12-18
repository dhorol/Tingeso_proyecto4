import axios from 'axios';

const API_URL = 'http://localhost:8080/profesores'; // URL del Gateway

const getProfesores = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data;
    } catch (error) {
        console.error('Error al obtener los profesores', error);
    }
};

// Exporta las funciones para usarlas en tus componentes
export { getProfesores };
