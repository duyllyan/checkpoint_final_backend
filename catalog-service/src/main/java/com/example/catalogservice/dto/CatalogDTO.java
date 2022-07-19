package com.example.catalogservice.dto;

import com.example.catalogservice.model.Movie;
import com.example.catalogservice.model.Serie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogDTO {
    String name;
    List<Movie> movies;
    List<Serie> series;
}
