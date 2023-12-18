package com.example.backendproyectoresservice.service;

import com.example.backendproyectoresservice.entities.DataProyectoresEntity;
import com.example.backendproyectoresservice.repositories.DataProyectoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataProyectoresService {

    @Autowired
    private DataProyectoresRepository dataProyectoresRepository;

    public List<DataProyectoresEntity> getAllProyectores() {
        return dataProyectoresRepository.findAll();
    }

    // Aquí se pueden agregar más métodos como addProyector, updateProyector, etc.
}
