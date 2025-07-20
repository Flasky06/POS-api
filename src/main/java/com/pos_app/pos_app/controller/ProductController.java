package com.pos_app.pos_app.controller;


import com.pos_app.pos_app.domain.dto.ProductDto;
import com.pos_app.pos_app.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
      return ResponseEntity.ok(productService.createProduct(productDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> listProducts(){
        return ResponseEntity.ok(productService.listProducts());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,
                                                    @PathVariable UUID productId){
        return ResponseEntity.ok(productService.updateProduct(productDto,productId));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable UUID productId){
        return  ResponseEntity.ok(productService.getProductById(productId));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID productId){
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
