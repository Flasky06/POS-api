package com.pos_app.pos_app.services.Impl;

import com.pos_app.pos_app.domain.dto.BrandDto;
import com.pos_app.pos_app.domain.dto.ProductDto;
import com.pos_app.pos_app.domain.entity.Brand;
import com.pos_app.pos_app.domain.entity.Category;
import com.pos_app.pos_app.domain.entity.Product;
import com.pos_app.pos_app.mapper.BrandMapper;
import com.pos_app.pos_app.mapper.CategoryMapper;
import com.pos_app.pos_app.mapper.ProductMapper;
import com.pos_app.pos_app.repository.BrandRepository;
import com.pos_app.pos_app.repository.CategoryRepository;
import com.pos_app.pos_app.repository.ProductRepository;
import com.pos_app.pos_app.services.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;
    private final BrandMapper brandMapper;
    private final CategoryMapper categoryMapper;

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

    @Override
    public ProductDto updateProduct(ProductDto productDto, UUID productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("No product found with that Id"));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setVolume(productDto.getVolume());
        product.setImageUrl(productDto.getImageUrl());

        // Extract IDs from BrandDto and CategoryDto
        UUID brandId = productDto.getBrand().getId();
        UUID categoryId = productDto.getCategory().getId();

        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found"));
        product.setBrand(brand);

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        product.setCategory(category);

        Product updatedProduct = productRepository.save(product);
        return productMapper.toDTO(updatedProduct);
    }


    @Override
    public ProductDto getProductById(UUID productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("No product found with that Id"));
        return productMapper.toDTO(product);
    }

    @Override
    public void deleteProduct(UUID productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("No product found with that Id"));

        productRepository.delete(product);
    }
}
