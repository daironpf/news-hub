package com.news.hub.languageservice.dto;

public record LanguageResponse(
    String id,
    String name,
    String url,
    String abbreviation,
    String urlFlag,
    Boolean status){
}
