package com.post.hub.categoryservice.dto;

public record CategoryResponse(
        String id,
        String name,
        String url,
        String description,
        String urlIcon ) {}
