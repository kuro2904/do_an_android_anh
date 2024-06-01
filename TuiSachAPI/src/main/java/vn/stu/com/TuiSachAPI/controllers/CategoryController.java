package vn.stu.com.TuiSachAPI.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.stu.com.TuiSachAPI.dtos.CategoryDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;
import vn.stu.com.TuiSachAPI.services.CategoryService;

import java.util.List;

import static vn.stu.com.TuiSachAPI.constants.Constant.nullError;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<CategoryDTO>>> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ResponseDTO<CategoryDTO>> getCategoryById(@PathVariable int categoryId) {
        ResponseDTO<CategoryDTO> response = categoryService.findById(categoryId);
        if (response.status() == 1) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<CategoryDTO>> addCategory(@RequestBody CategoryDTO categoryDTO) {
        if ( categoryDTO == null || categoryDTO.name() == null || categoryDTO.name().isEmpty())
            return ResponseEntity.badRequest().body(new ResponseDTO<>(null, 0, nullError("Category name")));
        return new ResponseEntity<>(categoryService.save(categoryDTO),HttpStatus.CREATED);
    }
}
