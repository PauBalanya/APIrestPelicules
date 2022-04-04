package com.example.apirest.model.repositoris;

import com.example.apirest.model.entitats.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoriPelicules extends JpaRepository<Pelicula,String> {
    List<Pelicula> findByGenere(String genere);
    long countByGenere(String genere);
    List<Pelicula> findByDuracioLessThan(double duracio);
}
