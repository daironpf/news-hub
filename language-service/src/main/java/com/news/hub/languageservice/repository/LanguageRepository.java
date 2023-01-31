package com.news.hub.languageservice.repository;

import com.news.hub.languageservice.dto.LanguageRequest;
import com.news.hub.languageservice.model.Language;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Optional;

public interface LanguageRepository extends Neo4jRepository<Language,String> {
    Optional<Language> findByName(String name);
    Optional<Language> findById(String id);

}
