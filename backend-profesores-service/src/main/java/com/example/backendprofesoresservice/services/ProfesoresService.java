package com.example.backendprofesoresservice.services;


import com.example.backendprofesoresservice.entities.ProfesoresEntity;
import com.example.backendprofesoresservice.repositories.ProfesoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesoresService {

    @Autowired
    private ProfesoresRepository profesorRepository;

    public List<ProfesoresEntity> getAllProfesores() {
        return profesorRepository.findAll();
    }

    // Más métodos como addProfesor, updateProfesor, etc.
}
