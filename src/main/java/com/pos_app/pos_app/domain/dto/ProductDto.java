package com.pos_app.pos_app.domain.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private UUID id;
    private String name;
    private BigDecimal price;
    private String volume;
    private String imageUrl;
    private CategoryDto category;
    private BrandDto brand;
}
