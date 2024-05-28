package vn.stu.com.TuiSachAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.stu.com.TuiSachAPI.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
