package vn.stu.com.TuiSachAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.stu.com.TuiSachAPI.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
