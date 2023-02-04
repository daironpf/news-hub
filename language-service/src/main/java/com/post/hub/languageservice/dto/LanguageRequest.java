package com.post.hub.languageservice.dto;

public record LanguageRequest(
        String name,
        String url,
        String abbreviation,
        String urlFlag,
        Boolean status
) {

}
