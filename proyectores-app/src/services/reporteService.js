import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/PyD/reportes';

const getReportes = async () => {
    try {
        const response = await axios.get(API_BASE_URL);
        return response.data;
    } catch (error) {
        console.error('Error al obtener los reportes', error);
        throw error;
    }
};

export { getReportes };
