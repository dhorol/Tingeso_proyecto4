package com.example.backendPyDservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Prestamos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private LocalDateTime fechaPrestamo;
    private String profesorId;  // o ProfesorEntity si usas relaciones
    private String proyectorId; // o DataProyectorEntity si usas relaciones
    private String uso; // Dictado de clases, Reuniones, etc.
}
