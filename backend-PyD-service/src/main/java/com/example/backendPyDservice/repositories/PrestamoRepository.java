package com.example.backendPyDservice.repositories;

import com.example.backendPyDservice.entities.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Long> {
    // Query para encontrar préstamos sin devolución asociada
    @Query("SELECT p FROM PrestamoEntity p WHERE p.id NOT IN (SELECT d.prestamoId FROM DevolucionEntity d)")
    List<PrestamoEntity> findPrestamosSinDevolucion();
}
