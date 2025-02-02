/**
 * Autora: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 * Cambios: José R. Hilera (2024) para eliminar la parte cliente de la aplicación original
 */

package com.lauracercas.moviecards.controller;

import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getMoviesList() {
        return (movieService.getAllMovies());
    }

    @PostMapping("/movies")
    public void newMovie(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @PutMapping("/movies")
    public void saveMovie(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @GetMapping("movies/{movieId}")
    public Movie editMovie(@PathVariable Integer movieId) {
        return movieService.getMovieById(movieId);
    }

    // Añadido
    @GetMapping("/movies/insc/{idActor}/{idMovie}")
    public void registerCard(@PathVariable("idActor") Integer idActor, @PathVariable("idMovie") Integer idMovie) {
        movieService.registerActorInMovie(idActor, idMovie);
    }

}
