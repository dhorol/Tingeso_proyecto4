package com.example.backendprofesoresservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Profesores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesoresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String departamento;
    private boolean habilitado = true; // Por defecto todos los profesores están habilitados
    private int contadorDanos = 0; // Contador para los proyectores dañados
    private LocalDateTime fechaRehabilitacion;

}
