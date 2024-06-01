package vn.stu.com.TuiSachAPI.mappers;

import org.springframework.stereotype.Service;
import vn.stu.com.TuiSachAPI.dtos.CategoryDTO;
import vn.stu.com.TuiSachAPI.entities.Category;

@Service
public class CategoryMapper {

    public CategoryDTO toCategoryDTO(Category category) {
        return new CategoryDTO(category.getId(),category.getName());
    }

}
