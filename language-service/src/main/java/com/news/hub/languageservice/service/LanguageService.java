package com.news.hub.languageservice.service;

import com.news.hub.languageservice.dto.LanguageRequest;
import com.news.hub.languageservice.dto.LanguageResponse;
import com.news.hub.languageservice.exception.DuplicateResourceException;
import com.news.hub.languageservice.exception.ResourceNotFoundException;
import com.news.hub.languageservice.mapper.LanguageDTOMapper;
import com.news.hub.languageservice.mapper.LanguageFromLanguageResponseMapper;
import com.news.hub.languageservice.mapper.LanguageResponseDTOMapper;
import com.news.hub.languageservice.model.Language;
import com.news.hub.languageservice.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;
    private final LanguageResponseDTOMapper languageResponseDTOMapper;
    private final LanguageDTOMapper languageDTOMapper;
    private final LanguageFromLanguageResponseMapper languageFromLanguageResponseMapper;

    @Transactional
    public LanguageResponse addLanguage(LanguageRequest languageRequest){
        if (languageRepository.findByName(languageRequest.name()).isPresent()) {
            throw new DuplicateResourceException("Name already taken");
        }

        Language newLanguage = languageRepository.save(languageDTOMapper.apply(languageRequest));
        return languageResponseDTOMapper.apply(newLanguage);
    }

    public List<LanguageResponse> getAllLanguage() {
        return languageRepository.findAll()
                .stream()
                .map(languageResponseDTOMapper)
                .collect(Collectors.toList());
    }

    public LanguageResponse findLanguageById(String languageId){
        Language newlanguage = languageRepository.findById(languageId).orElseThrow(
                ()-> new ResourceNotFoundException("Language with id [ %s ] not found".formatted(languageId))
        );
        return languageResponseDTOMapper.apply(newlanguage);
    }

    @Transactional
    public String deleteLanguageById(String languageId) {
        languageRepository.findById(languageId).orElseThrow(
                ()-> new ResourceNotFoundException("Language with id [ %s ] not found".formatted(languageId))
        );
        languageRepository.deleteById(languageId);
        return("Language by id "+languageId+" was Deleted");
    }

    @Transactional
    public LanguageResponse updateLanguage(LanguageResponse languageResponse) {
        languageRepository.findById(languageResponse.id()).orElseThrow(
                ()-> new ResourceNotFoundException("Language with id [ %s ] not found".formatted(languageResponse.id()))
        );
        Language newLanguage = languageRepository.save(languageFromLanguageResponseMapper.apply(languageResponse));
        return languageResponseDTOMapper.apply(newLanguage);
    }
}
