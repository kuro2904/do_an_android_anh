package vn.stu.com.TuiSachAPI.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.stu.com.TuiSachAPI.dtos.OrderDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;
import vn.stu.com.TuiSachAPI.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<OrderDTO>>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<OrderDTO>> placeOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.placeOrder(orderDTO));
    }

    @GetMapping("user/{id}")
    public ResponseEntity<ResponseDTO<List<OrderDTO>>> getUserOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderService.findByUser(id));
    }
}
