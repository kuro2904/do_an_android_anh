package vn.stu.com.TuiSachAPI.mappers;

import org.springframework.stereotype.Service;
import vn.stu.com.TuiSachAPI.dtos.OrderDTO;
import vn.stu.com.TuiSachAPI.dtos.OrderDetailDTO;
import vn.stu.com.TuiSachAPI.entities.Order;
import vn.stu.com.TuiSachAPI.entities.OrderDetail;

@Service
public class OrderMapper {

    public OrderDTO mapToDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getAddress(),
                order.getPhone(),
                order.getOrderDate(),
                order.getUser().getId(),
                order.getTotal(),
                order.getDetails().stream().map(this::mapToDetailDTO).toList()
        );
    }

    public OrderDetailDTO mapToDetailDTO(OrderDetail orderDetail) {
        return new OrderDetailDTO(
                orderDetail.getId(),
                orderDetail.getOrder().getId(),
                orderDetail.getProduct().getId(),
                orderDetail.getQuantity(),
                orderDetail.getPrice()
        );
    }

}
