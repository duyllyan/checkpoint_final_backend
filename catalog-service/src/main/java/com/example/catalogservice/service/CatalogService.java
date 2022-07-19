package com.example.catalogservice.service;

import com.example.catalogservice.dto.CatalogDTO;
import com.example.catalogservice.model.Movie;
import com.example.catalogservice.model.Serie;

public interface CatalogService {

    Movie getMovieById(String movieId);

    CatalogDTO getCatalogByGenre(String genre);

    void addNewMovie(Movie movie);

    void addNewSerie(Serie serie);
}
