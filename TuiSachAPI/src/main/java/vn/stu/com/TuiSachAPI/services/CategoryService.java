package vn.stu.com.TuiSachAPI.services;

import vn.stu.com.TuiSachAPI.dtos.CategoryDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;

import java.util.List;

public interface CategoryService {
    ResponseDTO<List<CategoryDTO>> findAll();

    ResponseDTO<CategoryDTO> findById(int id);

    ResponseDTO<CategoryDTO> save(CategoryDTO categoryDTO);
}
