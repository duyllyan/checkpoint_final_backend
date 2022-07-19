package com.example.catalogservice.repository;

import com.example.catalogservice.model.Season;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeasonRepository extends MongoRepository<Season, String> {
}
