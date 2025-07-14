package com.pos_app.pos_app.repository;

import com.pos_app.pos_app.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByCategory_NameIgnoreCase(String categoryName);
    List<Product> findByBrand_NameIgnoreCase(String brandName);

}
