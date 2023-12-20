import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/PyD/prestamos';



const createPrestamo = async (prestamoData) => {
    try {
        const response = await axios.post(API_BASE_URL, prestamoData);
        return response.data;
    } catch (error) {
        console.error('Error al crear un préstamo', error);
    }
};

// Otros métodos...

export { createPrestamo};