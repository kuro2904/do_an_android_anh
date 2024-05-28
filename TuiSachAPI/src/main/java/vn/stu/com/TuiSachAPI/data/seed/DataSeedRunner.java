package vn.stu.com.TuiSachAPI.data.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.stu.com.TuiSachAPI.entities.Role;
import vn.stu.com.TuiSachAPI.entities.User;
import vn.stu.com.TuiSachAPI.repositories.RoleRepository;
import vn.stu.com.TuiSachAPI.repositories.UserRepository;

import java.util.List;

@Component
public class DataSeedRunner implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public DataSeedRunner(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Create roles ( ADMIN and USER)
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        Role user = new Role();
        user.setName("ROLE_USER");
        roleRepository.saveAll(List.of(adminRole,user));

        User admin = new User();
        admin.setUserName("admin");
        admin.setPassword("admin");
        admin.setPhoneNumber("1234567890");
        admin.setRole(adminRole);
        userRepository.saveAll(List.of(admin));

        User user1 = new User();
        user1.setUserName("user1");
        user1.setPassword("password1");
        user1.setPhoneNumber("123");
        user1.setRole(user);

        User user2 = new User();
        user2.setUserName("user2");
        user2.setPassword("password2");
        user2.setPhoneNumber("456");
        user2.setRole(user);

        userRepository.saveAll(List.of(user1,user2));

    }
}
