package vn.stu.com.TuiSachAPI.services;

import vn.stu.com.TuiSachAPI.dtos.OrderDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;

import java.util.List;

public interface OrderService {
    ResponseDTO<List<OrderDTO>> getAll();
    ResponseDTO<OrderDTO> placeOrder(OrderDTO order);
    ResponseDTO<List<OrderDTO>> findByUser(int id);
}
