package com.post.hub.languageservice.mapper;

import com.post.hub.languageservice.dto.LanguageResponse;
import com.post.hub.languageservice.model.Language;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class LanguageFromLanguageResponseMapper implements Function<LanguageResponse, Language> {

    @Override
    public Language apply(LanguageResponse languageResponse) {
        return Language.builder()
                .id(languageResponse.id())
                .name(languageResponse.name())
                .url(languageResponse.url())
                .abbreviation(languageResponse.abbreviation())
                .urlFlag(languageResponse.urlFlag())
                .status(languageResponse.status())
                .build();
    }
}
