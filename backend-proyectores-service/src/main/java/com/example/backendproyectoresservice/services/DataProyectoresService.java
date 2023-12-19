package com.example.backendproyectoresservice.services;

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

    public DataProyectoresEntity addProyector(DataProyectoresEntity proyector) {
        return dataProyectoresRepository.save(proyector);
    }
    public DataProyectoresEntity updateProyector(Long proyectorId, DataProyectoresEntity proyectorDetails) {
        DataProyectoresEntity proyector = dataProyectoresRepository.findById(proyectorId)
                .orElseThrow(() -> new RuntimeException("Proyector no encontrado con id: " + proyectorId));

        proyector.setEstado(proyectorDetails.getEstado());
        return dataProyectoresRepository.save(proyector);
    }

    public void deleteProyector(Long proyectorId) {
        dataProyectoresRepository.deleteById(proyectorId);
    }

    public void updateDisponibilidad(Long proyectorId, boolean disponibilidad) {
        DataProyectoresEntity proyector = dataProyectoresRepository.findById(proyectorId)
                .orElseThrow(() -> new RuntimeException("Proyector no encontrado con id: " + proyectorId));
        proyector.setDisponible(disponibilidad);
        dataProyectoresRepository.save(proyector);
    }






}
