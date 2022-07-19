package com.example.catalogservice.controller;

import com.example.catalogservice.service.impl.CatalogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogServiceImpl catalogService;

    @GetMapping("/{genre}")
    public ResponseEntity<?> getCatalogByGenre(@PathVariable String genre) {
        return ResponseEntity.status(HttpStatus.OK).body(catalogService.getCatalogByGenre(genre));
    }

}
