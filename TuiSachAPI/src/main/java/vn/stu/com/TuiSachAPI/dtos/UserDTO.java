package vn.stu.com.TuiSachAPI.dtos;

import vn.stu.com.TuiSachAPI.entities.User;

public record UserDTO(
        int id,
        String userName,
        String password,
        String role,
        String phoneNumber
) {

}
