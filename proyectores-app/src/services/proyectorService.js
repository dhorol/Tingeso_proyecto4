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

const addProyector = async (proyector) => {
    try {
        const response = await axios.post(API_URL, proyector);
        return response.data;
    } catch (error) {
        console.error('Error al agregar el proyector', error);
    }
};
const updateProyector = async (id, proyector) => {
    try {
        const response = await axios.put(`${API_URL}/${id}`, proyector);
        return response.data;
    } catch (error) {
        console.error('Error al actualizar el proyector', error);
    }
};

export { getProyectores, addProyector, updateProyector };
