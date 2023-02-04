package com.news.hub.categoryservice.repository;

import com.news.hub.categoryservice.model.Category;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface CategoryRepository extends Neo4jRepository<Category,String> {
    Optional<Category> findByName(String name);
    Optional<Category> findById(String id);
    Optional<Category> findByUrl(String url);
    boolean existsCategoriesById(String id);
    boolean existsCategoriesByUrl(String url);
}
