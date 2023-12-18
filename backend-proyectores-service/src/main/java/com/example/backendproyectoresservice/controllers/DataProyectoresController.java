package com.example.backendproyectoresservice.controllers;

import com.example.backendproyectoresservice.entities.DataProyectoresEntity;
import com.example.backendproyectoresservice.service.DataProyectoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectores")
public class DataProyectoresController {

    @Autowired
    private DataProyectoresService dataProyectoresService;

    @GetMapping
    public List<DataProyectoresEntity> getAllProyectores() {
        return dataProyectoresService.getAllProyectores();
    }

    // Aquí se pueden agregar más endpoints como POST para agregar un proyector, etc.
}
