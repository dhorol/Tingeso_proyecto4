package com.example.backendPyDservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportePrestamosDTO {
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;
    private String nombreProfesor; // Información obtenida del microservicio de profesores
    private String marcaProyector; // Información obtenida del microservicio de proyectores
    private String estadoDevolucion;
    private String usoProyector;
    private Long duracionPrestamoEnHoras;

    // Constructor, getters y setters
}