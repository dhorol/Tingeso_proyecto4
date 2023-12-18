package com.example.backendPyDservice.repositories;

import com.example.backendPyDservice.entities.DevolucionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevolucionRepository extends JpaRepository<DevolucionEntity, Long> {
    // Métodos de consulta personalizados si es necesario
}
