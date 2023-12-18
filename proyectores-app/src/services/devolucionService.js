import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/PyD/devoluciones';

const getDevoluciones = async () => {
    try {
        const response = await axios.get(API_BASE_URL);
        return response.data;
    } catch (error) {
        console.error('Error al obtener las devoluciones', error);
    }
};

const createDevolucion = async (devolucionData) => {
    try {
        const response = await axios.post(API_BASE_URL, devolucionData);
        return response.data;
    } catch (error) {
        console.error('Error al crear una devolución', error);
    }
};

// Exporta las funciones para que puedan ser usadas en otros archivos
export { getDevoluciones, createDevolucion };
