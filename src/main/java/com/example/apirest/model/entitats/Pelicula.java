package com.example.apirest.model.entitats;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Pelicula {
    @Id
    private String idPelicula;
    private String titol;
    private String genere;
    private double duracio;
}

