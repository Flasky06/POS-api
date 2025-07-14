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
    private final BrandService typeService;

    @PostMapping
    public ResponseEntity<BrandDto> createType(@RequestBody BrandDto typeDto){
        return ResponseEntity.ok(typeService.createType(typeDto));
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> getTypes(){
        return ResponseEntity.ok(typeService.listBrands());
    }

    @PutMapping("/{brandId}")
    public  ResponseEntity<BrandDto> updateType(@RequestBody BrandDto typeDto,@PathVariable UUID brandId){
        return ResponseEntity.ok(typeService.updateBrand(typeDto,brandId));
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<BrandDto> getTypeById(@PathVariable UUID brandId){
        return  ResponseEntity.ok(typeService.getBrandById(brandId));
    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity<Void> deleteType(@PathVariable UUID brandId){
        return ResponseEntity.noContent().build();
    }
}
