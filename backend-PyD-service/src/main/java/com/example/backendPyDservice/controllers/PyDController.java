package com.example.backendPyDservice.controllers;


import com.example.backendPyDservice.entities.PrestamoEntity;
import com.example.backendPyDservice.entities.DevolucionEntity;
import com.example.backendPyDservice.models.ReportePrestamosDTO;
import com.example.backendPyDservice.services.PrestamoService;
import com.example.backendPyDservice.services.DevolucionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PyD")
public class PyDController {
    private static final Logger logger = LoggerFactory.getLogger(PrestamoService.class);

    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private DevolucionService devolucionService;

    // Endpoint para registrar un nuevo préstamo
    @PostMapping("/prestamos")
    public ResponseEntity<?> createPrestamo(@RequestBody PrestamoEntity prestamo) {
        try {
            PrestamoEntity newPrestamo = prestamoService.createPrestamo(prestamo);
            return ResponseEntity.ok(newPrestamo);
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el stack trace para depuración
            return ResponseEntity.badRequest().body("Error al crear el préstamo: " + e.getMessage());
        }
    }




    // Endpoint para registrar una nueva devolución
    @PostMapping("/devoluciones")
    public ResponseEntity<?> createDevolucion(@RequestBody DevolucionEntity devolucion) {
        try {
            DevolucionEntity nuevaDevolucion = devolucionService.createDevolucion(devolucion);
            return ResponseEntity.ok(nuevaDevolucion);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en la creación de la devolución: " + e.getMessage());
        }
    }

    // Endpoint para obtener reportes (este es un ejemplo, se puede personalizar más)
    @GetMapping("/reportes")
    public ResponseEntity<List<ReportePrestamosDTO>> getReportes() {
        try {
            logger.info("Solicitando reportes de prestamos y devoluciones");
            List<ReportePrestamosDTO> reportes = prestamoService.getReportes();
            return ResponseEntity.ok(reportes);
        } catch (Exception e) {
            logger.error("Error al obtener reportes", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/devoluciones/prestamos/pendientes")
    public ResponseEntity<List<PrestamoEntity>> getPrestamosPendientes() {
        try {
            List<PrestamoEntity> prestamosPendientes = prestamoService.getPrestamosPendientes();
            return ResponseEntity.ok(prestamosPendientes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
