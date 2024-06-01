package vn.stu.com.TuiSachAPI.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.stu.com.TuiSachAPI.dtos.CategoryDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;
import vn.stu.com.TuiSachAPI.entities.Category;
import vn.stu.com.TuiSachAPI.mappers.CategoryMapper;
import vn.stu.com.TuiSachAPI.repositories.CategoryRepository;
import vn.stu.com.TuiSachAPI.services.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ResponseDTO<List<CategoryDTO>> findAll() {
        return new ResponseDTO<>(categoryRepository.findAll().stream().map(categoryMapper::toCategoryDTO).toList(), 1, "All Categories");
    }

    @Override
    public ResponseDTO<CategoryDTO> findById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(value -> new ResponseDTO<>(categoryMapper.toCategoryDTO(value), 1, "Category with id " + id + " found"))
                .orElseGet(() -> new ResponseDTO<>(null, 0, "Category not found"));
    }

    @Override
    public ResponseDTO<CategoryDTO> save(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.name());
        return new ResponseDTO<>(categoryMapper.toCategoryDTO(categoryRepository.save(category)), 1, "Category saved");
    }
}
