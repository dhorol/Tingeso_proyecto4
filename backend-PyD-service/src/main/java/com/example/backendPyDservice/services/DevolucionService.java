package com.example.backendPyDservice.services;

import com.example.backendPyDservice.entities.DevolucionEntity;
import com.example.backendPyDservice.entities.PrestamoEntity;
import com.example.backendPyDservice.repositories.DevolucionRepository;
import com.example.backendPyDservice.repositories.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Service
public class DevolucionService {

    @Autowired
    private DevolucionRepository devolucionRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    private final RestTemplate restTemplate;

    public DevolucionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DevolucionEntity createDevolucion(DevolucionEntity devolucion) throws Exception {
        // Obtener el préstamo asociado
        PrestamoEntity prestamo = prestamoRepository.findById(devolucion.getPrestamoId())
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado con id: " + devolucion.getPrestamoId()));

        // Lógica para calcular la duración del préstamo y actualizar el estado del profesor si es necesario
        Duration duracion = Duration.between(prestamo.getFechaPrestamo(), devolucion.getFechaDevolucion());
        if (duracion.toHours() > 6) {
            // Llamada al microservicio de profesores para deshabilitar al profesor por una semana
            String url = "http://localhost:8080/profesores/" + prestamo.getProfesorId() + "/habilitacion";
            Map<String, Boolean> habilitacionMap = new HashMap<>();
            habilitacionMap.put("habilitado", false);
            restTemplate.put(url, habilitacionMap);

            // Aquí se podría agregar lógica para re-habilitar al profesor después de una semana
        }

        // Si el proyector se devuelve con daños, incrementar el contador de daños del profesor
        if ("Con Daños".equals(devolucion.getEstadoDevolucion())) {
            restTemplate.put("http://localhost:8080/profesores/" + prestamo.getProfesorId() + "/danos", null);
            String url = "http://localhost:8080/proyectores/" + prestamo.getProyectorId() + "/estado";
            Map<String, String> estadoMap = new HashMap<>();
            estadoMap.put("estado", "Con Daños");
            restTemplate.put(url, estadoMap);
        }

        // Actualizar la disponibilidad del proyector
        String url = "http://localhost:8080/proyectores/" + prestamo.getProyectorId() + "/disponibilidad";
        restTemplate.put(url, true);
        // Guardar la devolución
        return devolucionRepository.save(devolucion);
    }


    // Métodos para deshabilitar profesor, incrementar daños y actualizar disponibilidad del proyector
}