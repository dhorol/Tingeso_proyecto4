package com.example.backendprofesoresservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    // Puedes agregar otros campos como email, etc.
}
