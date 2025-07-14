package com.pos_app.pos_app.mapper;

import com.pos_app.pos_app.domain.dto.CategoryDto;
import com.pos_app.pos_app.domain.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDTO(Category category);

    Category toEntity(CategoryDto dto);


}
