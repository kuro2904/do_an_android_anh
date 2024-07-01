package vn.stu.com.TuiSachAPI.dtos;

import vn.stu.com.TuiSachAPI.entities.OrderDetail;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(
        int id,
        String address,
        String phone,
        LocalDateTime orderDate,
        int userId,
        double total,
        List<OrderDetailDTO> details
) {
}
