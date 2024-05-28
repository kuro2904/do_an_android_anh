package vn.stu.com.TuiSachAPI.entities;

import jakarta.persistence.*;
import vn.stu.com.TuiSachAPI.dtos.UserDTO;

import java.util.List;

@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String phoneNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

    public User(){}

    public User(int id, String userName, String password, String phoneNumber, Role role, List<Order> orderList) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.orderList = orderList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
