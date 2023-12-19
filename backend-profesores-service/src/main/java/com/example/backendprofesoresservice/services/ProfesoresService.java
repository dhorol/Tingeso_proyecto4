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

    public ProfesoresEntity addProfesor(ProfesoresEntity profesor) {
        return profesorRepository.save(profesor);
    }

    public void deleteProfesor(Long profesorId) {
        profesorRepository.deleteById(profesorId);
    }

}
