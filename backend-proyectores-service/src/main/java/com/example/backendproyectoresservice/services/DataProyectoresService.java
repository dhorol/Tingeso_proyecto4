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


    public DataProyectoresEntity cambiarDisponibilidad(Long proyectorId, boolean disponible) {
        DataProyectoresEntity proyector = dataProyectoresRepository.findById(proyectorId)
                .orElseThrow(() -> new RuntimeException("Proyector no encontrado con id: " + proyectorId));

        proyector.setDisponible(disponible);
        return dataProyectoresRepository.save(proyector);
    }

    public DataProyectoresEntity findById(Long proyectorId) {
        return dataProyectoresRepository.findById(proyectorId).orElse(null);
    }

    public boolean isValidUsageForProyector(Long proyectorId, String uso) {
        DataProyectoresEntity proyector = findById(proyectorId);
        if (proyector == null) {
            throw new RuntimeException("Proyector no encontrado con id: " + proyectorId);
        }

        String marca = proyector.getMarca();
        switch (marca) {
            case "EPSON":
                return "Dictado de Clases".equals(uso) || "Exámenes de Título".equals(uso);
            case "ViewSonic":
                return "Reuniones Varias".equals(uso);
            default:
                return false; // O cualquier lógica que desees para marcas no especificadas
        }
    }

    public DataProyectoresEntity cambiarEstadoProyector(Long id, String nuevoEstado) {
        DataProyectoresEntity proyector = dataProyectoresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyector no encontrado con id: " + id));

        proyector.setEstado(nuevoEstado);
        return dataProyectoresRepository.save(proyector);
    }







}
