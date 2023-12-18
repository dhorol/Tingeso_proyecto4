package com.example.backendproyectoresservice.controllers;

import com.example.backendproyectoresservice.entities.DataProyectoresEntity;
import com.example.backendproyectoresservice.services.DataProyectoresService;
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

    @PostMapping
    public DataProyectoresEntity addProyector(@RequestBody DataProyectoresEntity proyector) {
        return dataProyectoresService.addProyector(proyector);
    }
    @PutMapping("/{id}")
    public DataProyectoresEntity updateProyector(@PathVariable Long id, @RequestBody DataProyectoresEntity proyectorDetails) {
        return dataProyectoresService.updateProyector(id, proyectorDetails);
    }



}
