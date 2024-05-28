package vn.stu.com.TuiSachAPI.services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.stu.com.TuiSachAPI.dtos.LoginDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;
import vn.stu.com.TuiSachAPI.dtos.UserDTO;
import vn.stu.com.TuiSachAPI.entities.User;
import vn.stu.com.TuiSachAPI.repositories.RoleRepository;
import vn.stu.com.TuiSachAPI.repositories.UserRepository;
import vn.stu.com.TuiSachAPI.services.AuthService;

import java.util.Optional;

import static vn.stu.com.TuiSachAPI.constants.Constant.*;
import static vn.stu.com.TuiSachAPI.constants.Constant.LOGIN_WRONG_PASSWORD;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public AuthServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }


    @Override
    public ResponseDTO<UserDTO> login(LoginDTO loginDTO) {
        User user = userRepository.findByUserNameOrPhoneNumber(loginDTO.usernameOrPhoneNumber(), loginDTO.usernameOrPhoneNumber());
        if (user == null) return new ResponseDTO<>(null, 0, LOGIN_UNAUTHORIZED);
        if (!user.getPassword().equals(loginDTO.password())) return new ResponseDTO<>(null, 0, LOGIN_WRONG_PASSWORD);
        return new ResponseDTO<>(new UserDTO(user), 1, LOGIN_SUCCESSFUL);
    }

    @Override
    public ResponseDTO<UserDTO> register(UserDTO user) {
        User userDB = userRepository.findByUserNameOrPhoneNumber(user.getUserName(), user.getPhoneNumber());
        if (userDB != null) return new ResponseDTO<>(null, 0, REGISTER_USER_EXISTED);
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setPassword(user.getPassword());
        newUser.setRole(roleRepository.findByName("ROLE_USER"));
        return new ResponseDTO<>(new UserDTO(newUser), 1, REGISTER_SUCCESSFUL);
    }
}
