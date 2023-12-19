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
const addProfesor = async (profesorData) => {
    try {
        const response = await axios.post(API_URL, profesorData);
        return response.data;
    } catch (error) {
        console.error('Error al añadir el profesor', error);
    }
};

const deleteProfesor = async (id) => {
    try {
        await axios.delete(`${API_URL}/${id}`);
    } catch (error) {
        console.error('Error al eliminar el profesor', error);
    }
};

export { getProfesores, addProfesor, deleteProfesor };
