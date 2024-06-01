package vn.stu.com.TuiSachAPI.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.stu.com.TuiSachAPI.dtos.LoginDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;
import vn.stu.com.TuiSachAPI.dtos.UserDTO;
import vn.stu.com.TuiSachAPI.entities.User;
import vn.stu.com.TuiSachAPI.mappers.UserMapper;
import vn.stu.com.TuiSachAPI.repositories.RoleRepository;
import vn.stu.com.TuiSachAPI.repositories.UserRepository;
import vn.stu.com.TuiSachAPI.services.AuthService;

import static vn.stu.com.TuiSachAPI.constants.Constant.*;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public AuthServiceImpl(RoleRepository roleRepository, UserRepository userRepository, UserMapper userMapper) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseDTO<UserDTO> login(LoginDTO loginDTO) {
        User user = userRepository.findByUserNameOrPhoneNumber(loginDTO.usernameOrPhoneNumber(), loginDTO.usernameOrPhoneNumber());
        if (user == null) return new ResponseDTO<>(null, 0, LOGIN_UNAUTHORIZED);
        if (!user.getPassword().equals(loginDTO.password())) return new ResponseDTO<>(null, 0, LOGIN_WRONG_PASSWORD);
        return new ResponseDTO<>(userMapper.toUSerDTO(user), 1, LOGIN_SUCCESSFUL);
    }

    @Override
    public ResponseDTO<UserDTO> register(UserDTO user) {
        User userDB = userRepository.findByUserNameOrPhoneNumber(user.userName(), user.phoneNumber());
        if (userDB != null) return new ResponseDTO<>(null, 0, REGISTER_USER_EXISTED);
        User newUser = new User();
        newUser.setUserName(user.userName());
        newUser.setPhoneNumber(user.phoneNumber());
        newUser.setPassword(user.password());
        newUser.setRole(roleRepository.findByName("ROLE_USER"));
        return new ResponseDTO<>(userMapper.toUSerDTO(newUser), 1, REGISTER_SUCCESSFUL);
    }
}
