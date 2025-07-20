package com.pos_app.pos_app.controller;


import com.pos_app.pos_app.domain.dto.BrandDto;
import com.pos_app.pos_app.services.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/brand")
@AllArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<BrandDto> createType(@RequestBody BrandDto typeDto){
        return ResponseEntity.ok(brandService.createType(typeDto));
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> getTypes(){
        return ResponseEntity.ok(brandService.listBrands());
    }

    @PutMapping("/{brandId}")
    public  ResponseEntity<BrandDto> updateType(@RequestBody BrandDto typeDto,@PathVariable UUID brandId){
        return ResponseEntity.ok(brandService.updateBrand(typeDto,brandId));
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<BrandDto> getTypeById(@PathVariable UUID brandId){
        return  ResponseEntity.ok(brandService.getBrandById(brandId));
    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity<Void> deleteType(@PathVariable UUID brandId){
        brandService.deleteBrand(brandId);
        return ResponseEntity.noContent().build();
    }
}
