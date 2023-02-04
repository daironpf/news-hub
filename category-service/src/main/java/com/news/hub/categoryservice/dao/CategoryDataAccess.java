package com.news.hub.categoryservice.dao;

import com.news.hub.categoryservice.model.Category;
import com.news.hub.categoryservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CategoryDataAccess implements CategoryDAO{
    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findByName(String name) { return categoryRepository.findByName(name); }

    @Override
    public Optional<Category> findByUrl(String url) { return categoryRepository.findByUrl(url); }

    @Override
    public boolean existsCategoryByUrl(String url) { return categoryRepository.existsCategoriesByUrl(url); }

    @Override
    public boolean existsCategoryById(String id) { return categoryRepository.existsCategoriesById(id); }

    @Override
    public Category create(Category category) { return categoryRepository.save(category); }

    @Override
    public Optional<Category> findById(String id) { return categoryRepository.findById(id); }

    @Override
    public Category update(Category category) { return categoryRepository.save(category); }

    @Override
    public void deleteById(String id) { categoryRepository.deleteById(id);}

    @Override
    public List<Category> findAll() { return categoryRepository.findAll(); }
}
