package com.post.hub.languageservice.dao;

import com.post.hub.languageservice.model.Language;

import java.util.Optional;

public interface LanguageDAO extends GenericDAO<Language, String>{
    Optional<Language> findByName(String name);
    Optional<Language> findByUrl(String url);
    boolean existsLanguageById(String id);
}
