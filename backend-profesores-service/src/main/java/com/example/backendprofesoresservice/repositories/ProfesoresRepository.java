package com.example.backendprofesoresservice.repositories;


import com.example.backendprofesoresservice.entities.ProfesoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesoresRepository extends JpaRepository<ProfesoresEntity, Long> {
    // Consultas personalizadas si se requieren
}
