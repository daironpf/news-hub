package com.news.hub.languageservice.dao;

import com.news.hub.languageservice.model.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageDAO extends GenericDAO<Language, String>{
    Optional<Language> findByName(String name);
    Optional<Language> findByUrl(String url);
    boolean existsLanguageById(String id);
}
