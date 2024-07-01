package vn.stu.com.TuiSachAPI.dtos;

public record OrderDetailDTO(
        int id,
        int orderId,
        int productId,
        int quantity,
        double price
) {
}
