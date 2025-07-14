package com.pos_app.pos_app.services.Impl;

import com.pos_app.pos_app.domain.dto.ProductDto;
import com.pos_app.pos_app.domain.entity.Product;
import com.pos_app.pos_app.mapper.ProductMapper;
import com.pos_app.pos_app.repository.ProductRepository;
import com.pos_app.pos_app.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);

        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }

    @Override
    public List<ProductDto> listProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }
}
