package com.pos_app.pos_app.mapper;

import com.pos_app.pos_app.domain.dto.ProductDto;
import com.pos_app.pos_app.domain.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDTO(Product product);
    Product toEntity(ProductDto productDto);
}
