package com.example.backendprofesoresservice.repositories;


import com.example.backendprofesoresservice.entities.ProfesoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesoresRepository extends JpaRepository<ProfesoresEntity, Long> {
    List<ProfesoresEntity> findByHabilitadoFalse();
}
