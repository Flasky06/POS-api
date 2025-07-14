package com.pos_app.pos_app.mapper;

import com.pos_app.pos_app.domain.dto.BrandDto;
import com.pos_app.pos_app.domain.entity.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandDto toDTO(Brand type);
    Brand toEntity(BrandDto typeDto);
}
