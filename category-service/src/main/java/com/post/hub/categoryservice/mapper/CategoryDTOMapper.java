package com.post.hub.categoryservice.mapper;

import com.post.hub.categoryservice.dto.CategoryRequest;
import com.post.hub.categoryservice.model.Category;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class CategoryDTOMapper implements Function<CategoryRequest, Category> {
    @Override
    public Category apply(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.name())
                .description(categoryRequest.description())
                .url(categoryRequest.url())
                .urlIcon(categoryRequest.urlIcon())
                .build();
    }
}