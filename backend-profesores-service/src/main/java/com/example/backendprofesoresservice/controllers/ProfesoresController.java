package com.example.backendprofesoresservice.controllers;


import com.example.backendprofesoresservice.entities.ProfesoresEntity;
import com.example.backendprofesoresservice.services.ProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profesores")
public class ProfesoresController {

    @Autowired
    private ProfesoresService profesoresService;

    @GetMapping
    public List<ProfesoresEntity> getAllProfesores() {
        return profesoresService.getAllProfesores();
    }

    @PostMapping
    public ProfesoresEntity addProfesor(@RequestBody ProfesoresEntity profesor) {
        return profesoresService.addProfesor(profesor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfesor(@PathVariable Long id) {
        profesoresService.deleteProfesor(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/habilitacion")
    public ResponseEntity<?> cambiarHabilitacion(@PathVariable Long id, @RequestBody Map<String, Boolean> habilitacionMap) {
        try {
            boolean habilitado = habilitacionMap.getOrDefault("habilitado", true);
            ProfesoresEntity profesorActualizado = profesoresService.cambiarHabilitacion(id, habilitado);
            return ResponseEntity.ok(profesorActualizado);
        } catch (Exception e) {
            // Manejar la excepción según tus necesidades
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cambiar la habilitación del profesor: " + e.getMessage());
        }
    }


    @PutMapping("/{id}/danos")
    public ResponseEntity<?> incrementarDanos(@PathVariable Long id) {
        ProfesoresEntity profesorActualizado = profesoresService.incrementarDanos(id);
        return ResponseEntity.ok(profesorActualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesoresEntity> getProfesorById(@PathVariable Long id) {
        try {
            ProfesoresEntity profesor = profesoresService.getProfesorById(id);
            return ResponseEntity.ok(profesor);
        } catch (Exception e) {
            // Aquí puedes manejar la excepción según tus necesidades
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    @GetMapping("/{id}/habilitado")
    public ResponseEntity<Boolean> isProfesorHabilitado(@PathVariable Long id) {
        Boolean habilitado = profesoresService.isProfesorHabilitado(id);
        if (habilitado != null) {
            return ResponseEntity.ok(habilitado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
