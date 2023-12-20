package com.example.backendprofesoresservice.services;


import com.example.backendprofesoresservice.entities.ProfesoresEntity;
import com.example.backendprofesoresservice.repositories.ProfesoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfesoresService {

    @Autowired
    private ProfesoresRepository profesorRepository;

    public List<ProfesoresEntity> getAllProfesores() {
        return profesorRepository.findAll();
    }

    public ProfesoresEntity addProfesor(ProfesoresEntity profesor) {
        return profesorRepository.save(profesor);
    }

    public void deleteProfesor(Long profesorId) {
        profesorRepository.deleteById(profesorId);
    }

    // En ProfesoresService

    public ProfesoresEntity incrementarDanos(Long profesorId) {
        ProfesoresEntity profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        profesor.setContadorDanos(profesor.getContadorDanos() + 1);
        if (profesor.getContadorDanos() >= 3) {
            profesor.setHabilitado(false);
            // Si se deshabilita permanentemente, no se configura fechaRehabilitacion
        }
        return profesorRepository.save(profesor);
    }

    public ProfesoresEntity rehabilitarProfesor(Long profesorId) {
        ProfesoresEntity profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        if (LocalDateTime.now().isAfter(profesor.getFechaRehabilitacion())) {
            profesor.setHabilitado(true);
            profesor.setFechaRehabilitacion(null);
        }
        return profesorRepository.save(profesor);
    }

    @Scheduled(fixedRate = 60000) // Ejecuta cada 60 segundos. Ajusta según necesidad
    public void rehabilitarProfesoresDeshabilitados() {
        List<ProfesoresEntity> profesoresDeshabilitados = profesorRepository.findByHabilitadoFalse();
        LocalDateTime now = LocalDateTime.now();

        for (ProfesoresEntity profesor : profesoresDeshabilitados) {
            if (profesor.getFechaRehabilitacion() != null && now.isAfter(profesor.getFechaRehabilitacion())) {
                profesor.setHabilitado(true);
                profesor.setFechaRehabilitacion(null);
                profesorRepository.save(profesor);
            }
        }
    }

    // Otros métodos necesarios


    public ProfesoresEntity cambiarHabilitacion(Long profesorId, boolean habilitado) {
        ProfesoresEntity profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id: " + profesorId));

        profesor.setHabilitado(habilitado);
        return profesorRepository.save(profesor);
    }

    public Boolean isProfesorHabilitado(Long id) {
        return profesorRepository.findById(id)
                .map(ProfesoresEntity::isHabilitado) // Asume que tienes un campo 'habilitado' en tu entidad
                .orElse(null);
    }

    public ProfesoresEntity getProfesorById(Long id) {
        return profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id: " + id));
    }






}
