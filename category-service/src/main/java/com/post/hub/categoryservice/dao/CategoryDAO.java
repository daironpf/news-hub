package com.post.hub.categoryservice.dao;

import com.post.hub.categoryservice.model.Category;

import java.util.Optional;

public interface CategoryDAO extends GenericDAO<Category,String>{
    Optional<Category> findByName(String name);
    Optional<Category> findByUrl(String url);
    boolean existsCategoryByUrl(String url);
    boolean existsCategoryById(String id);
}
