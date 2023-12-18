package com.example.backendproyectoresservice.repositories;


import com.example.backendproyectoresservice.entities.DataProyectoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataProyectoresRepository extends JpaRepository<DataProyectoresEntity, Long> {
    // Aquí pueden ir consultas personalizadas si es necesario
}
