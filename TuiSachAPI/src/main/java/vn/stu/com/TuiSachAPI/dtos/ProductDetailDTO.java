package vn.stu.com.TuiSachAPI.dtos;

public record ProductDetailDTO(
        int id,
        String size,
        String color,
        int quantity,
        String imagePath
) {
}
