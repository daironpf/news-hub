package com.news.hub.languageservice.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID>{
    T create (T entity);
    Optional<T> findById(ID id);
    T update(T entity);
    void deleteById(ID id);
    List<T> findAll();
}
