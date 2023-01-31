package com.news.hub.languageservice.mapper;

import com.news.hub.languageservice.dto.LanguageRequest;
import com.news.hub.languageservice.model.Language;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class LanguageDTOMapper implements Function <LanguageRequest, Language> {
    @Override
    public Language apply(LanguageRequest languageRequest) {
        return Language.builder()
                .name(languageRequest.name())
                .url(languageRequest.url())
                .abbreviation(languageRequest.abbreviation())
                .urlFlag(languageRequest.urlFlag())
                .status(languageRequest.status())
                .build();
    }
}
