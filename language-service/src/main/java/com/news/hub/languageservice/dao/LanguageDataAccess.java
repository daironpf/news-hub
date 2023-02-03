package com.news.hub.languageservice.dao;

import com.news.hub.languageservice.model.Language;
import com.news.hub.languageservice.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class LanguageDataAccess implements LanguageDAO {
    private final LanguageRepository languageRepository;

    @Override
    public Language create(Language language) {return languageRepository.save(language); }

    @Override
    public Optional<Language> findById(String id) { return languageRepository.findById(id); }

    @Override
    public Language update(Language language) { return languageRepository.save(language); }

    @Override
    public void deleteById(String id) { languageRepository.deleteById(id); }

    @Override
    public List<Language> findAll() { return languageRepository.findAll(); }

    @Override
    public Optional<Language> findByName(String name) { return languageRepository.findByName(name); }

    @Override
    public Optional<Language> findByUrl(String url) { return languageRepository.findByUrl(url); }

    @Override
    public boolean existsLanguageById(String id) { return languageRepository.existsById(id); }
}
