package vn.stu.com.TuiSachAPI.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.stu.com.TuiSachAPI.dtos.LoginDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;
import vn.stu.com.TuiSachAPI.dtos.UserDTO;
import vn.stu.com.TuiSachAPI.services.AuthService;

import static vn.stu.com.TuiSachAPI.constants.Constant.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("login")
    public ResponseEntity<ResponseDTO<UserDTO>> login(@RequestBody LoginDTO loginDTO) {
        if (loginDTO.usernameOrPhoneNumber() == null || loginDTO.usernameOrPhoneNumber().trim().isEmpty())
            return ResponseEntity.badRequest().body(new ResponseDTO<>(null, 0, nullError("Phone number")));
        if(loginDTO.password() == null || loginDTO.password().trim().isEmpty())
            return ResponseEntity.badRequest().body(new ResponseDTO<>(null, 0, nullError("Password")));
        ResponseDTO<UserDTO> responseDTO = authService.login(loginDTO);
        if (responseDTO.status() == 0)
            return new ResponseEntity<>(responseDTO, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<ResponseDTO<UserDTO>> register(@RequestBody UserDTO userDTO) {
        if (userDTO.phoneNumber() == null || userDTO.phoneNumber().isEmpty())
            return ResponseEntity.badRequest().body(new ResponseDTO<>(null, 0, nullError("Phone number")));
        if (userDTO.password() == null || userDTO.password().isEmpty())
            return ResponseEntity.badRequest().body(new ResponseDTO<>(null, 0, nullError("Password")));
        if (userDTO.userName() == null || userDTO.userName().isEmpty())
            return ResponseEntity.badRequest().body(new ResponseDTO<>(null, 0, nullError("User name")));
        return new ResponseEntity<>(authService.register(userDTO), HttpStatus.CREATED);
    }

}
