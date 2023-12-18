package com.example.backendPyDservice.services;


import com.example.backendPyDservice.entities.DevolucionEntity;
import com.example.backendPyDservice.repositories.DevolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevolucionService {

    @Autowired
    private DevolucionRepository devolucionRepository;

    public DevolucionEntity createDevolucion(DevolucionEntity devolucion) {
        // Aquí se puede agregar lógica adicional antes de guardar la devolución
        return devolucionRepository.save(devolucion);
    }

    // Más métodos según sea necesario
}
