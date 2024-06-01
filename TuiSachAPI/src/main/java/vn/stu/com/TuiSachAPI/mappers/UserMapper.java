package vn.stu.com.TuiSachAPI.mappers;

import org.springframework.stereotype.Service;
import vn.stu.com.TuiSachAPI.dtos.UserDTO;
import vn.stu.com.TuiSachAPI.entities.User;

@Service
public class UserMapper {

    public UserDTO toUSerDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getRole().getName(),
                user.getPhoneNumber()
        );
    }

}
