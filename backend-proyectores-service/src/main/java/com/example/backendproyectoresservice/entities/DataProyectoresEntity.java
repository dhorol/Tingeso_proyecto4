package com.example.backendproyectoresservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DataProyectores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataProyectoresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String marca;
    private String estado;
    private boolean disponible = true;

}
