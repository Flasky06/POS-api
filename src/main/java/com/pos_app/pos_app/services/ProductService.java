package com.pos_app.pos_app.services;

import com.pos_app.pos_app.domain.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> listProducts();

    ProductDto updateProduct(ProductDto productDto, UUID productId);

    ProductDto getProductById(UUID productId);

    void deleteProduct(UUID productId);
}
