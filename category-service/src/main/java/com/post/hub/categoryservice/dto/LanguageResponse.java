package com.post.hub.categoryservice.dto;

public record LanguageResponse(
    String id,
    String name,
    String url,
    String abbreviation,
    String urlFlag,
    Boolean status ){}
