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

const deleteProyector = async (id) => {
    try {
        await axios.delete(`${API_URL}/${id}`);
    } catch (error) {
        console.error('Error al eliminar el proyector', error);
    }
};
const updateDisponibilidad = async (id, disponible) => {
    try {
        await axios.patch(`${API_URL}/${id}/disponibilidad?disponible=${disponible}`);
    } catch (error) {
        console.error('Error al actualizar la disponibilidad del proyector', error);
    }
};

export { getProyectores, addProyector, updateProyector, deleteProyector, updateDisponibilidad };