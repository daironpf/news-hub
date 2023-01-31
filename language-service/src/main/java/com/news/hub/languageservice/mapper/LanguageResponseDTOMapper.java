package com.news.hub.languageservice.mapper;

import com.news.hub.languageservice.dto.LanguageResponse;
import com.news.hub.languageservice.model.Language;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class LanguageResponseDTOMapper implements Function <Language, LanguageResponse> {
    @Override
    public LanguageResponse apply(Language language){
        return new LanguageResponse(
                language.getId(),
                language.getName(),
                language.getUrl(),
                language.getAbbreviation(),
                language.getUrlFlag(),
                language.getStatus()
        );
    }
}
