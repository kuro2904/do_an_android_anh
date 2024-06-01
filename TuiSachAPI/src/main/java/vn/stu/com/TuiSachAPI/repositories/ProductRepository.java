package vn.stu.com.TuiSachAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.stu.com.TuiSachAPI.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
