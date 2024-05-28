package vn.stu.com.TuiSachAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.stu.com.TuiSachAPI.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserNameOrPhoneNumber(String userName, String phoneNumber);
}
