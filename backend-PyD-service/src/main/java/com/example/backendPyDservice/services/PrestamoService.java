package com.example.backendPyDservice.services;

import com.example.backendPyDservice.entities.PrestamoEntity;
import com.example.backendPyDservice.repositories.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    private final RestTemplate restTemplate;

    public PrestamoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PrestamoEntity createPrestamo(PrestamoEntity prestamo) throws Exception {
        // Validar si el proyector está disponible
        if (!isProyectorDisponible(prestamo.getProyectorId())) {
            throw new Exception("El proyector ya está en uso.");
        }

        // Validar si el profesor está habilitado
        if (!isProfesorHabilitado(prestamo.getProfesorId())) {
            throw new Exception("El profesor no está habilitado para realizar préstamos.");
        }

        // Validar uso del proyector según su marca
        if (!isValidUsageForProyector(prestamo.getProyectorId(), prestamo.getUso())) {
            throw new Exception("Uso del proyector no permitido según su marca.");
        }

        // Guardar el préstamo
        return prestamoRepository.save(prestamo);
    }

    private boolean isProyectorDisponible(String proyectorId) {
        // Suponiendo que hay un endpoint /proyectores/{id}/disponibilidad
        String url = "http://direccion-microservicio-proyectores/proyectores/" + proyectorId + "/disponibilidad";
        Boolean disponible = restTemplate.getForObject(url, Boolean.class);
        return disponible != null && disponible;
    }

    private boolean isProfesorHabilitado(String profesorId) {
        // Suponiendo que hay un endpoint /profesores/{id}/habilitado
        String url = "http://direccion-microservicio-profesores/profesores/" + profesorId + "/habilitado";
        Boolean habilitado = restTemplate.getForObject(url, Boolean.class);
        return habilitado != null && habilitado;
    }

    private boolean isValidUsageForProyector(String proyectorId, String uso) {
        // Suponiendo que hay un endpoint /proyectores/{id}/uso-valido?uso={uso}
        String url = "http://direccion-microservicio-proyectores/proyectores/" + proyectorId + "/uso-valido?uso=" + uso;
        Boolean usoValido = restTemplate.getForObject(url, Boolean.class);
        return usoValido != null && usoValido;
    }

    // Otros métodos necesarios
}
