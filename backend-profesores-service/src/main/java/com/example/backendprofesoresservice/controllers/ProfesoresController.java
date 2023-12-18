package com.example.backendprofesoresservice.controllers;


import com.example.backendprofesoresservice.entities.ProfesoresEntity;
import com.example.backendprofesoresservice.services.ProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesoresController {

    @Autowired
    private ProfesoresService profesoresService;

    @GetMapping
    public List<ProfesoresEntity> getAllProfesores() {
        return profesoresService.getAllProfesores();
    }

    // Endpoints adicionales como POST para añadir un profesor, etc.
}
