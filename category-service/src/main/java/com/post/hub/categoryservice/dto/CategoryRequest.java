package com.post.hub.categoryservice.dto;

public record CategoryRequest(
        String id,
        String name,
        String url,
        String description,
        String urlIcon,
        LanguageResponse inLanguage ) {}
