package com.post.hub.languageservice.repository;

import com.post.hub.languageservice.model.Language;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface LanguageRepository extends Neo4jRepository<Language,String> {
    Optional<Language> findByName(String name);
    Optional<Language> findById(String id);
    Optional<Language> findByUrl(String url);
    boolean existsLanguageById(String id);
}
