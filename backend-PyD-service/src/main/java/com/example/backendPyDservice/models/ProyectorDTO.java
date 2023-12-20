package com.example.backendPyDservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyectorDTO {
    private Long id;
    private String marca;
    private String estado;
}
