package com.pos_app.pos_app.services;

import com.pos_app.pos_app.domain.dto.BrandDto;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    BrandDto createType (BrandDto brandDto);

    List<BrandDto> listBrands();

    BrandDto getBrandById(UUID brandId);

    BrandDto updateBrand(BrandDto brandDto, UUID brandId);

    void deleteBrand(UUID brandId);


}
