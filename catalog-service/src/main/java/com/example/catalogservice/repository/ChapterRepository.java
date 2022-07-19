package com.example.catalogservice.repository;

import com.example.catalogservice.model.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChapterRepository extends MongoRepository<Chapter, String> {
}
