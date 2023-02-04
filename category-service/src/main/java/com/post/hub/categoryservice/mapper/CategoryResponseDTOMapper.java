package com.post.hub.categoryservice.mapper;

import com.post.hub.categoryservice.dto.CategoryRequest;
import com.post.hub.categoryservice.dto.CategoryResponse;
import com.post.hub.categoryservice.model.Category;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CategoryResponseDTOMapper implements Function<Category, CategoryResponse> {
    @Override
    public CategoryResponse apply(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getUrl(),
                category.getDescription(),
                category.getUrlIcon()
        );
    }
}