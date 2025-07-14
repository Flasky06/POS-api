package com.pos_app.pos_app.controller;

import com.pos_app.pos_app.domain.dto.CategoryDto;
import com.pos_app.pos_app.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.CreateCategory(categoryDto));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories() {
        return ResponseEntity.ok(categoryService.listCategories());
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(
            @PathVariable UUID categoryId, @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.UpdateCategory(categoryDto,categoryId));

    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable UUID categoryId){
      return  ResponseEntity.ok(categoryService.GetCategoryById(categoryId));
    }

    @DeleteMapping("/{category}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID categoryId){
        return  ResponseEntity.noContent().build();
    }

}
