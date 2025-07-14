package com.pos_app.pos_app.services.Impl;

import com.pos_app.pos_app.domain.dto.BrandDto;
import com.pos_app.pos_app.domain.entity.Brand;
import com.pos_app.pos_app.mapper.BrandMapper;
import com.pos_app.pos_app.repository.BrandRepository;
import com.pos_app.pos_app.services.BrandService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandMapper brandMapper;
    private final BrandRepository brandRepository;

    @Override
    public BrandDto createType(BrandDto brandDto) {
        Brand type = brandMapper.toEntity(brandDto);

        Brand savedBrand = brandRepository.save(type);

        return brandMapper.toDTO(savedBrand);
    }

    @Override
    public List<BrandDto> listBrands() {
     return brandRepository.findAll()
                .stream()
                .map(brandMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BrandDto getBrandById(UUID brandId) {
        Brand type = brandRepository.findById(brandId)
                .orElseThrow(()-> new EntityNotFoundException("Brand not found"));
        return brandMapper.toDTO(type);
    }

    @Override
    public BrandDto updateBrand(BrandDto brandDto, UUID brandId) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(()->new EntityNotFoundException("Brand not found"));

        brand.setName(brandDto.getName());

        Brand updatedType = brandRepository.save(brand);
        return brandMapper.toDTO(updatedType);
    }

    @Override
    public void deleteBrand(UUID brandId) {
        Brand type = brandRepository.findById(brandId)
                .orElseThrow(()->new EntityNotFoundException("Brand not found"));

        brandRepository.delete(type);
    }
}
