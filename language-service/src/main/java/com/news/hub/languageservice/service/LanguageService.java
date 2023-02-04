package com.news.hub.languageservice.service;

import com.news.hub.languageservice.dao.LanguageDAO;
import com.news.hub.languageservice.dto.LanguageRequest;
import com.news.hub.languageservice.dto.LanguageResponse;
import com.news.hub.languageservice.exception.DuplicateResourceException;
import com.news.hub.languageservice.exception.ResourceNotFoundException;
import com.news.hub.languageservice.mapper.LanguageDTOMapper;
import com.news.hub.languageservice.mapper.LanguageFromLanguageResponseMapper;
import com.news.hub.languageservice.mapper.LanguageResponseDTOMapper;
import com.news.hub.languageservice.model.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageDAO languageDAO;
    private final LanguageResponseDTOMapper languageResponseDTOMapper;
    private final LanguageDTOMapper languageDTOMapper;
    private final LanguageFromLanguageResponseMapper languageFromLanguageResponseMapper;

    @Transactional
    public LanguageResponse addLanguage(LanguageRequest languageRequest){
        if (languageDAO.findByName(languageRequest.name()).isPresent()) {
            throw new DuplicateResourceException("Name already taken");
        }

        Language newLanguage = languageDAO.create(languageDTOMapper.apply(languageRequest));
        return languageResponseDTOMapper.apply(newLanguage);
    }

    public List<LanguageResponse> getAllLanguage() {
        return languageDAO.findAll()
                .stream()
                .map(languageResponseDTOMapper)
                .collect(Collectors.toList());
    }

    public LanguageResponse findLanguageById(String languageId){
        Language newlanguage = languageDAO.findById(languageId).orElseThrow(
                ()-> new ResourceNotFoundException("Language with id [ %s ] not found".formatted(languageId))
        );
        return languageResponseDTOMapper.apply(newlanguage);
    }

    @Transactional
    public String deleteLanguageById(String languageId) {
        languageDAO.findById(languageId).orElseThrow(
                ()-> new ResourceNotFoundException("Language with id [ %s ] not found".formatted(languageId))
        );
        languageDAO.deleteById(languageId);
        return("Language by id "+languageId+" was Deleted");
    }

    @Transactional
    public LanguageResponse updateLanguage(LanguageResponse languageResponse) {
        languageDAO.findById(languageResponse.id()).orElseThrow(
                ()-> new ResourceNotFoundException("Language with id [ %s ] not found".formatted(languageResponse.id()))
        );
        Language newLanguage = languageDAO.update(languageFromLanguageResponseMapper.apply(languageResponse));
        return languageResponseDTOMapper.apply(newLanguage);
    }
}
