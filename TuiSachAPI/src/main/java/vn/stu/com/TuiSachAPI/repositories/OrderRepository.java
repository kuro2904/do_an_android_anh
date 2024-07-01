package vn.stu.com.TuiSachAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.stu.com.TuiSachAPI.entities.Order;
import vn.stu.com.TuiSachAPI.entities.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUser(User user);
}
