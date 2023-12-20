package com.example.backendproyectoresservice.controllers;

import com.example.backendproyectoresservice.entities.DataProyectoresEntity;
import com.example.backendproyectoresservice.services.DataProyectoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProyector(@PathVariable Long id) {
        dataProyectoresService.deleteProyector(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}/disponibilidad")
    public ResponseEntity<?> cambiarDisponibilidad(@PathVariable Long id, @RequestBody Boolean disponible) {
        try {
            DataProyectoresEntity proyectorActualizado = dataProyectoresService.cambiarDisponibilidad(id, disponible);
            return ResponseEntity.ok(proyectorActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cambiar la disponibilidad: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/disponibilidad")
    public ResponseEntity<Boolean> getDisponibilidadProyector(@PathVariable Long id) {
        try {
            DataProyectoresEntity proyector = dataProyectoresService.findById(id);
            if (proyector == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(proyector.isDisponible());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/{id}/uso-valido")
    public ResponseEntity<?> isValidUsage(@PathVariable Long id, @RequestParam String uso) {
        try {
            boolean isValid = dataProyectoresService.isValidUsageForProyector(id, uso);
            return ResponseEntity.ok(isValid);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al verificar el uso: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> cambiarEstadoProyector(@PathVariable Long id, @RequestBody Map<String, String> estadoMap) {
        try {
            DataProyectoresEntity proyectorActualizado = dataProyectoresService.cambiarEstadoProyector(id, estadoMap.get("estado"));
            return ResponseEntity.ok(proyectorActualizado);
        } catch (Exception e) {
            // Manejar la excepción según tus necesidades
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cambiar el estado del proyector: " + e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<DataProyectoresEntity> getProyectorById(@PathVariable Long id) {
        try {
            DataProyectoresEntity proyector = dataProyectoresService.findById(id);
            if (proyector == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(proyector);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }





}
