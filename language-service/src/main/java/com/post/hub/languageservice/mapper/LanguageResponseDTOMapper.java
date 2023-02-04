package com.post.hub.languageservice.mapper;

import com.post.hub.languageservice.dto.LanguageResponse;
import com.post.hub.languageservice.model.Language;
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
