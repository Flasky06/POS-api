package com.pos_app.pos_app.services;

import com.pos_app.pos_app.domain.dto.CategoryDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryDto CreateCategory(CategoryDto categoryDto);

    List<CategoryDto> listCategories();

    CategoryDto GetCategoryById(UUID categoryId);

    CategoryDto UpdateCategory (CategoryDto categoryDto, UUID categoryId);

    void DeleteCategory(UUID categoryId);
}
