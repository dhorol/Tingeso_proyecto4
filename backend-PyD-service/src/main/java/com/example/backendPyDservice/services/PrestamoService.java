package com.example.backendPyDservice.services;

import com.example.backendPyDservice.entities.DevolucionEntity;
import com.example.backendPyDservice.entities.PrestamoEntity;
import com.example.backendPyDservice.models.ProfesorDTO;
import com.example.backendPyDservice.models.ProyectorDTO;
import com.example.backendPyDservice.models.ReportePrestamosDTO;
import com.example.backendPyDservice.repositories.DevolucionRepository;
import com.example.backendPyDservice.repositories.PrestamoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrestamoService {
    private static final Logger logger = LoggerFactory.getLogger(PrestamoService.class);

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private DevolucionRepository devolucionRepository;

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


        PrestamoEntity nuevoPrestamo = prestamoRepository.save(prestamo);

        // Actualizar la disponibilidad del proyector a no disponible
        String url = "http://localhost:8080/proyectores/" + prestamo.getProyectorId() + "/disponibilidad";
        restTemplate.put(url, false);
        return nuevoPrestamo;
    }

    private boolean isProyectorDisponible(Long proyectorId) {
        String url = "http://localhost:8080/proyectores/" + proyectorId + "/disponibilidad";
        Boolean disponible = restTemplate.getForObject(url, Boolean.class);
        return disponible != null && disponible;
    }

    private boolean isProfesorHabilitado(Long profesorId) {
        String url = "http://localhost:8080/profesores/" + profesorId + "/habilitado";
        Boolean habilitado = restTemplate.getForObject(url, Boolean.class);
        return habilitado != null && habilitado;
    }

    private boolean isValidUsageForProyector(Long proyectorId, String uso) {
        String url = "http://localhost:8080/proyectores/" + proyectorId + "/uso-valido?uso=" + uso;
        Boolean usoValido = restTemplate.getForObject(url, Boolean.class);
        return usoValido != null && usoValido;
    }


    public List<ReportePrestamosDTO> getReportes() {
        logger.info("Iniciando la obtención de reportes");
        List<PrestamoEntity> prestamos = prestamoRepository.findAll();
        List<ReportePrestamosDTO> reportes = new ArrayList<>();

        for (PrestamoEntity prestamo : prestamos) {
            try {
                ReportePrestamosDTO reporte = new ReportePrestamosDTO();
                reporte.setFechaPrestamo(prestamo.getFechaPrestamo());

                // Obtener información del profesor
                String urlProfesor = "http://localhost:8080/profesores/" + prestamo.getProfesorId();
                ProfesorDTO profesor = restTemplate.getForObject(urlProfesor, ProfesorDTO.class);
                if (profesor != null) {
                    reporte.setNombreProfesor(profesor.getNombre());
                }

                // Obtener información del proyector
                String urlProyector = "http://localhost:8080/proyectores/" + prestamo.getProyectorId();
                ProyectorDTO proyector = restTemplate.getForObject(urlProyector, ProyectorDTO.class);
                if (proyector != null) {
                    reporte.setMarcaProyector(proyector.getMarca());
                }

                // Obtener información de la devolución, si existe
                DevolucionEntity devolucion = devolucionRepository.findByPrestamoId(prestamo.getId());
                if (devolucion != null) {
                    reporte.setFechaDevolucion(devolucion.getFechaDevolucion());
                    reporte.setEstadoDevolucion(devolucion.getEstadoDevolucion());
                } else {
                    reporte.setEstadoDevolucion("Pendiente"); // O cualquier otro valor por defecto
                }

                reporte.setUsoProyector(prestamo.getUso());
                if (devolucion != null) {
                    reporte.setDuracionPrestamoEnHoras(Duration.between(prestamo.getFechaPrestamo(), devolucion.getFechaDevolucion()).toHours());
                } else {
                    reporte.setDuracionPrestamoEnHoras(null); // o un valor por defecto si es necesario
                }

                reportes.add(reporte);
            } catch (Exception e) {
                logger.error("Error al procesar el prestamo ID: {}", prestamo.getId(), e);
            }
        }
        return reportes;
    }

    public List<PrestamoEntity> getPrestamosPendientes() {
        return prestamoRepository.findPrestamosSinDevolucion();
    }

    // Otros métodos necesarios
}
