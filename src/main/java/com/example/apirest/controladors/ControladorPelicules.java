package com.example.apirest.controladors;

import com.example.apirest.model.entitats.Pelicula;
import com.example.apirest.model.serveis.ServeiPelicules;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class ControladorPelicules {
    private final ServeiPelicules serveiPelicules;

    @CrossOrigin(origins="http://localhost:9001")
    @GetMapping("/pelicules")
    public List<Pelicula> llistarPelicules(@RequestParam (value="duracio", required=false) String duracio){
        if(duracio==null){
            return serveiPelicules.llistarPelis();
        }
        else return serveiPelicules.llistatPerDuracioMenorA(Double.parseDouble(duracio));
    }

    @GetMapping("/pelicules/{id}")
    public ResponseEntity<?> consultarPelicula(@PathVariable String id) {
        Pelicula res = serveiPelicules.consultarPelis(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @GetMapping("/pelicules/genere/{genere}")
    public List<Pelicula> llistarPeliculesPerGenere(@PathVariable String genere){
        return serveiPelicules.llistarPelisPerGenere(genere);
    }

    @GetMapping("/pelicules/comptar/{genere}")
    public long comptarPerGenere(@PathVariable String genere){
        return serveiPelicules.comptarPerGenere(genere);
    }

    @PostMapping("/pelicules")
    public ResponseEntity<Pelicula> crearPelicula(@RequestBody Pelicula nou){
        Pelicula res=serveiPelicules.afegirPeli(nou);
        return new ResponseEntity<Pelicula>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/pelicules/{id}")
    public ResponseEntity<Pelicula> eliminarPelicula(@PathVariable String id){
        Pelicula res = serveiPelicules.eliminarPeli(id);
        if (res==null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    @PutMapping("/pelicules")
    public ResponseEntity<Pelicula> modificarPelicula(@PathVariable Pelicula pelicula){
        Pelicula res = serveiPelicules.modificarPeli(pelicula);
        if (res==null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

}
