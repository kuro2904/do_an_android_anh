package vn.stu.com.TuiSachAPI.dtos;

import java.util.List;

public record ProductDTO(
        int id,
        String name,
        String description,
        double price,
        int categoryId,
        List<ProductDetailDTO> details
) {
}
