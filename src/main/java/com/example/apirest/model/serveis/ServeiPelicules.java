package com.example.apirest.model.serveis;

import com.example.apirest.model.entitats.Pelicula;
import com.example.apirest.model.repositoris.RepositoriPelicules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ServeiPelicules {
    private final RepositoriPelicules repoPelis;

    public List<Pelicula> llistarPelis(){
        return repoPelis.findAll();
    }

    public List<Pelicula> llistarPelisPerGenere(String gen){
        return repoPelis.findByGenere(gen);
    }

    public long comptarPerGenere(String gen){
        return repoPelis.countByGenere(gen);
    }

    public List<Pelicula> llistatPerDuracioMenorA(double duracio){
        return repoPelis.findByDuracioLessThan(duracio);
    }

    public Pelicula consultarPelis(String id){
        return repoPelis.findById(id).orElse(null);
    }

    public Pelicula afegirPeli(Pelicula it){
        return repoPelis.save(it);
    }

    public Pelicula modificarPeli(Pelicula peli){
        Pelicula aux=null;
        if(repoPelis.existsById(peli.getIdPelicula())) aux=repoPelis.save(peli);
        return aux;
    }

    public Pelicula eliminarPeli(String id){
        Pelicula res=repoPelis.findById(id).orElse(null);
        if(res!=null) repoPelis.deleteById(id);
        return res;
    }
}
