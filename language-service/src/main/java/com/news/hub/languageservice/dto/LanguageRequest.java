package com.news.hub.languageservice.dto;

public record LanguageRequest(
        String name,
        String url,
        String abbreviation,
        String urlFlag,
        Boolean status
) {

}
