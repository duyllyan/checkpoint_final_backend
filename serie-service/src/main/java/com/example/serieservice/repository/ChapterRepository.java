package com.example.serieservice.repository;

import com.example.serieservice.model.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChapterRepository extends MongoRepository<Chapter, String> {
}