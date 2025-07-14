package com.pos_app.pos_app.services.Impl;

import com.pos_app.pos_app.domain.dto.CategoryDto;
import com.pos_app.pos_app.domain.entity.Category;
import com.pos_app.pos_app.mapper.CategoryMapper;
import com.pos_app.pos_app.repository.CategoryRepository;
import com.pos_app.pos_app.services.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    @Override
    public CategoryDto CreateCategory(CategoryDto categoryDto) {

        Category category  = categoryMapper.toEntity(categoryDto);

        Category savedCategory  = categoryRepository.save(category);
        return categoryMapper.toDTO(savedCategory);
    }

    @Override
    public List<CategoryDto> listCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto GetCategoryById(UUID categoryId) {
        Category category  = categoryRepository.findById(categoryId)
                .orElseThrow(()->new EntityNotFoundException("Category Not Found"));
        return categoryMapper.toDTO(category);
    }

    @Override
    public CategoryDto UpdateCategory(CategoryDto categoryDto, UUID categoryId) {
        Category category  = categoryRepository.findById(categoryId)
                .orElseThrow(()->new EntityNotFoundException("Category Not Found"));

        category.setName(categoryDto.getName());

        Category updateCategory = categoryRepository.save(category);
        return categoryMapper.toDTO(updateCategory);
    }

    @Override
    public void DeleteCategory(UUID categoryId) {
        Category category  = categoryRepository.findById(categoryId)
                .orElseThrow(()->new EntityNotFoundException("Category Not Found"));

        categoryRepository.delete(category);
    }
}
