package com.example.catalogservice.service.impl;

import com.example.catalogservice.dto.CatalogDTO;
import com.example.catalogservice.model.Movie;
import com.example.catalogservice.model.Serie;
import com.example.catalogservice.repository.MovieRepository;
import com.example.catalogservice.repository.SerieRepository;
import com.example.catalogservice.service.CatalogService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private static final Logger log = Logger.getLogger(CatalogServiceImpl.class.getName());

    private final SerieRepository serieRepository;
    private final MovieRepository movieRepository;

    @Override
    public Movie getMovieById(String movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public CatalogDTO getCatalogByGenre(String genre) {
        List<Movie> movies = movieRepository.findAllByGenre(genre);
        List<Serie> series = serieRepository.findAllByGenre(genre);
        return new CatalogDTO(genre.toUpperCase(),movies,series);
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public void addNewMovie(Movie movie){
        log.info("Received a Movie by message from Rabbit Queue to save the Movie on CatalogService...");
        movieRepository.save(movie);
        log.info("... Movie saved at Catalog's database!");
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public void addNewSerie(Serie serie) {
        log.info("Received a Series by message from Rabbit Queue to save the Series on CatalogService...");
        serieRepository.save(serie);
        log.info("... Series saved at Catalog's database!");
    }

}
