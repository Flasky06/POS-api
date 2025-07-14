package com.pos_app.pos_app.services;

import com.pos_app.pos_app.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> listProducts();
}
