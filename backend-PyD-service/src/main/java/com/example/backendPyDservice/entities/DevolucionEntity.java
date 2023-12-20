package com.example.backendPyDservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Devoluciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevolucionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private LocalDateTime fechaDevolucion;
    private String estadoDevolucion; // Buenas Condiciones, Con Daños
    private Long prestamoId; // o PrestamoEntity si usas relaciones
}
