package com.example.backendPyDservice.repositories;

import com.example.backendPyDservice.entities.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Long> {
    // Aquí puedes añadir métodos de consulta personalizados si es necesario
}
