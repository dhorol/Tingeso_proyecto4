package com.example.backendPyDservice.controllers;


import com.example.backendPyDservice.entities.PrestamoEntity;
import com.example.backendPyDservice.entities.DevolucionEntity;
import com.example.backendPyDservice.services.PrestamoService;
import com.example.backendPyDservice.services.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PyD")
public class PyDController {

    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private DevolucionService devolucionService;

    // Endpoint para registrar un nuevo préstamo
    @PostMapping("/prestamos")
    public PrestamoEntity createPrestamo(@RequestBody PrestamoEntity prestamo) {
        return prestamoService.createPrestamo(prestamo);
    }

    // Endpoint para registrar una nueva devolución
    @PostMapping("/devoluciones")
    public DevolucionEntity createDevolucion(@RequestBody DevolucionEntity devolucion) {
        return devolucionService.createDevolucion(devolucion);
    }

    // Endpoint para obtener reportes (este es un ejemplo, se puede personalizar más)
    @GetMapping("/reportes")
    public List<Object> getReportes() {
        // Implementar lógica para obtener reportes aquí
        return null;
    }

    // Aquí se pueden agregar más endpoints según sea necesario
}