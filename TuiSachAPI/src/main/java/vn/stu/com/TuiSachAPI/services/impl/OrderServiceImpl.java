package vn.stu.com.TuiSachAPI.services.impl;

import org.springframework.stereotype.Service;
import vn.stu.com.TuiSachAPI.dtos.OrderDTO;
import vn.stu.com.TuiSachAPI.dtos.OrderDetailDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;
import vn.stu.com.TuiSachAPI.entities.*;
import vn.stu.com.TuiSachAPI.mappers.OrderMapper;
import vn.stu.com.TuiSachAPI.repositories.OrderRepository;
import vn.stu.com.TuiSachAPI.repositories.ProductDetailRepository;
import vn.stu.com.TuiSachAPI.repositories.ProductRepository;
import vn.stu.com.TuiSachAPI.repositories.UserRepository;
import vn.stu.com.TuiSachAPI.services.OrderService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;
    private final ProductDetailRepository productDetailRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository, OrderMapper orderMapper, ProductDetailRepository productDetailRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.orderMapper = orderMapper;
        this.productDetailRepository = productDetailRepository;
    }

    @Override
    public ResponseDTO<List<OrderDTO>> getAll() {
        return new ResponseDTO<>(orderRepository.findAll().stream().map(orderMapper::mapToDTO).toList(), 1, "All Order");
    }

    @Override
    public ResponseDTO<OrderDTO> placeOrder(OrderDTO req) {
        Optional<User> user = userRepository.findById(req.userId());
        if(user.isEmpty()) {
            return new ResponseDTO<>(null,0,"User not found");
        }

        if(req.details().isEmpty()){
            return new ResponseDTO<>(null,0,"Order details not valid");
        }

        Order order = new Order();
        order.setUser(user.get());
        order.setAddress(req.address());
        order.setPhone(req.phone());
        order.setOrderDate(LocalDateTime.now());
        order = orderRepository.save(order);

        for(OrderDetailDTO detailDTO : req.details()){
            Optional<ProductDetail> productDetail = productDetailRepository.findById(detailDTO.productId());
            if(productDetail.isEmpty()) {
                return new ResponseDTO<>(null,0,"Product not found");
            }
            order.getDetails().add(new OrderDetail(order,productDetail.get(), detailDTO.quantity(), detailDTO.price()));
        }

        return new ResponseDTO<>(orderMapper.mapToDTO(orderRepository.save(order)),1,"Order created");
    }

    @Override
    public ResponseDTO<List<OrderDTO>> findByUser(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value ->
                new ResponseDTO<>(orderRepository.findByUser(value).stream().map(orderMapper::mapToDTO).toList(), 1, "All Order By User"))
                .orElseGet(() -> new ResponseDTO<>(null, 0, "User not found"));
    }
}
