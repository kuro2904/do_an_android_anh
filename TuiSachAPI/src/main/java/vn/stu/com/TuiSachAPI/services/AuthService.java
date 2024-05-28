package vn.stu.com.TuiSachAPI.services;

import vn.stu.com.TuiSachAPI.dtos.LoginDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;
import vn.stu.com.TuiSachAPI.dtos.UserDTO;

public interface AuthService {

    ResponseDTO<UserDTO> login(LoginDTO username);
    ResponseDTO<UserDTO> register(UserDTO user);

}
