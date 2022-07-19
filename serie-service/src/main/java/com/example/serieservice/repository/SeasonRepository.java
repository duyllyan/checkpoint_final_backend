package com.example.serieservice.repository;

import com.example.serieservice.model.Season;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeasonRepository extends MongoRepository<Season, String> {
}