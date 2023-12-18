package com.example.backendPyDservice.services;

import com.example.backendPyDservice.entities.PrestamoEntity;
import com.example.backendPyDservice.repositories.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public PrestamoEntity createPrestamo(PrestamoEntity prestamo) {
        // Aquí se puede agregar lógica adicional antes de guardar el préstamo
        return prestamoRepository.save(prestamo);
    }

    // Aquí se pueden agregar más métodos según sea necesario
}
