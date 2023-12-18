import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/PyD/prestamos';

const getPrestamos = async () => {
    try {
        const response = await axios.get(API_BASE_URL);
        return response.data;
    } catch (error) {
        console.error('Error al obtener los préstamos', error);
    }
};

const createPrestamo = async (prestamoData) => {
    try {
        const response = await axios.post(API_BASE_URL, prestamoData);
        return response.data;
    } catch (error) {
        console.error('Error al crear un préstamo', error);
    }
};

// Exporta las funciones para que puedan ser usadas en otros archivos
export { getPrestamos, createPrestamo };
