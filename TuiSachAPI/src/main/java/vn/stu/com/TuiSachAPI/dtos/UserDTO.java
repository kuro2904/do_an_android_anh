package vn.stu.com.TuiSachAPI.dtos;

import vn.stu.com.TuiSachAPI.entities.User;

public class UserDTO {
    private int id;
    private String userName;
    private String password;
    private String role;
    private String phoneNumber;

    public UserDTO(int id, String userName, String password,String phoneNumber, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.phoneNumber = user.getPhoneNumber();
        this.role = user.getRole().getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
