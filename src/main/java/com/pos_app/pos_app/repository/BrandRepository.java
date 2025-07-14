package com.pos_app.pos_app.repository;

import com.pos_app.pos_app.domain.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
}
